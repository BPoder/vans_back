package com.example.vans_back.domain.van.driver;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Resource
    private DriverRepository driverRepository;

//    public Optional<Driver> getDriver(Integer userId) {
//        Optional<Driver> driverOptional = driverRepository.findDriverBy(userId);
//        return driverOptional;
//    }

    public Integer getDriverIdBy(Integer userId) {
        Driver driver = driverRepository.findDriverByUserId(userId).get();
        return driver.getId();
    }

    public Driver getDriverBy(Integer driverId) {
       return driverRepository.findDriverByDriverId(driverId).get();
    }
}
