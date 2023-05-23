package com.example.vans_back.business.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.domain.van.VanAllInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/all-info")
    @Operation(summary = "Leiab süsteemist (andmebaasist van tabelist) kõik kaubikud.",
            description = "Tagastab kogu olemasoleva info kõikide kaubikute kohta.")
    public List<VanAllInfo> getVans(@RequestParam Integer cityId, @RequestParam Integer vanId) {
        List<VanAllInfo> allVans = vansService.getVans(cityId, vanId);
        return allVans;
    }
}
