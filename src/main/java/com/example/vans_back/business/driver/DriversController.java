package com.example.vans_back.business.driver;

import com.example.vans_back.domain.van.driver.DriverAllInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriversController {

    @Resource
    private DriversService driversService;

    @GetMapping("/all-info")
    @Operation(summary = "Tagastab süsteemist (andmebaasist driver tabelist) juhtide info.",
            description = "Kui cityId ja driverId on 0-id, siis tagastab kõik juhid.")
    public List<DriverAllInfo> getDrivers(@RequestParam Integer cityId, @RequestParam Integer driverId) {
        List<DriverAllInfo> drivers = driversService.getDrivers(cityId, driverId);
        return drivers;
    }
}
