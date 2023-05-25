package com.example.vans_back.domain.van.driver;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Resource
    private DriverRepository driverRepository;

    public Integer getDriverIdBy(Integer userId) {
        Driver driver = driverRepository.findDriverByUserId(userId).get();
        return driver.getId();
    }

    public Driver getDriverBy(Integer driverId) {
       return driverRepository.findDriverByDriverId(driverId).get();
    }

    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> findDriversBy(Integer vanId) {
        List<Driver> byVanId = driverRepository.findByVan_Id(vanId);
        return byVanId;
    }

    public void saveAllDrivers(List<Driver> drivers) {
        driverRepository.saveAll(drivers);
    }

    public List<Driver> getDriversBy(Integer cityId, Integer driverId) {
        List<Driver> drivers = driverRepository.findDriversBy(cityId, driverId);
        return drivers;
    }
}
