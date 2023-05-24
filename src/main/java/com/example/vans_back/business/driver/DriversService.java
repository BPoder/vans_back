package com.example.vans_back.business.driver;

import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.business.van.dto.DriverAllInfo;
import com.example.vans_back.domain.van.driver.DriverMapper;
import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriversService {

    @Resource
    private DriverService driverService;

    @Resource
    private DriverMapper driverMapper;
    public List<DriverAllInfo> getDrivers(Integer cityId, Integer driverId) {
        List<Driver> drivers = driverService.getDriversBy(cityId, driverId);
        List<DriverAllInfo> driverAllInfos = driverMapper.toDriverAllInfos(drivers);
        return driverAllInfos;
    }
}
