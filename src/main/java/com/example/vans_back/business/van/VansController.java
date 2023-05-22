package com.example.vans_back.business.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/van")
public class VansController {

    @Resource
    private VansService vansService;

    @GetMapping("/basic-info")
    @Operation(summary = "Tagastab driverId kaudu kaubiku reg nr ja kindlustuse info.")
    public VanBasicInfo getUserVanInfo(@RequestParam Integer driverId) {
        VanBasicInfo vanBasicInfo = vansService.getUserVanInfo(driverId);
        return vanBasicInfo;
    }
}
