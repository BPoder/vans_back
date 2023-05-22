package com.example.vans_back.domain.van.driver;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Resource
    private DriverRepository driverRepository;

//    public Optional<Driver> getDriver(Integer userId) {
//        Optional<Driver> driverOptional = driverRepository.findDriverBy(userId);
//        return driverOptional;
//    }

    public Integer getDriverIdBy(Integer userId) {
        Driver driver = driverRepository.findDriverBy(userId).get();
        return driver.getId();
    }

    public void getVanBasicInfo(Integer driverId) {

    }
}
