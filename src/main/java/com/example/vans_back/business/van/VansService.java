package com.example.vans_back.business.van;

import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class VansService {

    @Resource
    private DriverService driverService;

    @Resource
    private VanMapper vanMapper;

    public void getUserVanInfo(Integer driverId) {
        driverService.getVanBasicInfo(driverId);
        //getDriverVanBy(driverId)?

    }
}
