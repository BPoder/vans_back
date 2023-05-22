package com.example.vans_back.business.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.domain.van.Van;
import com.example.vans_back.domain.van.VanAllInfo;
import com.example.vans_back.domain.van.VanMapper;
import com.example.vans_back.domain.van.VanService;
import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.domain.van.driver.DriverMapper;
import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VansService {

    @Resource
    private DriverService driverService;

    @Resource
    private DriverMapper driverMapper;

    @Resource
    private VanService vanService;

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
}
