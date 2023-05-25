package com.example.vans_back.business.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.business.van.dto.VanRequest;
import com.example.vans_back.domain.van.Van;
import com.example.vans_back.business.van.dto.VanAllInfo;
import com.example.vans_back.domain.van.VanDto;
import com.example.vans_back.domain.van.VanMapper;
import com.example.vans_back.domain.van.VanService;
import com.example.vans_back.domain.van.city.City;
import com.example.vans_back.domain.van.city.CityService;
import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.domain.van.driver.DriverMapper;
import com.example.vans_back.domain.van.driver.DriverService;
import com.example.vans_back.domain.van.insurance.Insurance;
import com.example.vans_back.domain.van.insurance.InsuranceMapper;
import com.example.vans_back.domain.van.insurance.InsuranceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VansService {

    @Resource
    private DriverService driverService;

    @Resource
    private VanService vanService;

    @Resource
    private CityService cityService;

    @Resource
    private InsuranceService insuranceService;

    @Resource
    private DriverMapper driverMapper;

    @Resource
    private InsuranceMapper insuranceMapper;

    @Resource
    private VanMapper vanMapper;

    public VanBasicInfo getUserVanInfo(Integer driverId) {
        Driver driver = driverService.getDriverBy(driverId);
        VanBasicInfo vanBasicInfo = driverMapper.toVanBasicInfo(driver);
        return vanBasicInfo;
    }

    public List<VanAllInfo> getVans(Integer cityId, Integer vanId) {
        List<Van> allVans = vanService.getVansBy(cityId, vanId);
        List<VanAllInfo> vans = vanMapper.toVanAllInfos(allVans);
        return vans;
    }

    @Transactional
    public void addVan(VanRequest vanRequest) {
        Van van = vanMapper.toVan(vanRequest);

        City city = cityService.findCityBy(vanRequest.getCityId());
        van.setCity(city);

        Insurance insurance;

        boolean insuranceProviderExists = insuranceService.insuranceExistsByProvider(vanRequest.getInsuranceProvider());
        if (insuranceProviderExists) {
            insurance = insuranceService.findInsuranceBy(vanRequest.getInsuranceProvider());
        } else {
            insurance = insuranceMapper.toInsurance(vanRequest);
            insuranceService.addInsurance(insurance);
        }

        van.setInsurance(insurance);

        vanService.addVan(van);

        Integer driverId = vanRequest.getDriverId();
        if (driverId != 0) {
            Driver driver = driverService.getDriverBy(driverId);
            driver.setVan(van);
            driverService.addDriver(driver);
        }
    }

    public void deleteVan(Integer vanId) {
        vanService.deactivateVan(vanId);

        List<Driver> drivers = driverService.findDriversBy(vanId);
        for (Driver driver : drivers) {
            driver.setVan(null);
        }
        driverService.saveAllDrivers(drivers);

        // todo: driverService -> driverRepository findDriversBy(vanId) ('drivers')
        //  update (for tsükkel) all 'drivers' van objects to null
        //  driverService -> driverRepository saveAllDrivers('drivers')
    }

    public List<VanDto> getAllVans() {
        List<Van> vans = vanService.getAllVans();
        List<VanDto> vanDtos = vanMapper.toVanDto(vans);
        return vanDtos;
    }
}
