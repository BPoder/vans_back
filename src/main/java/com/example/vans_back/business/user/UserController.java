package com.example.vans_back.business.user;

import com.example.vans_back.domain.van.driver.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private DriverService driverService;





}
