package com.example.vans_back.business.driver;

import com.example.vans_back.business.van.dto.DriverAllInfo;
import com.example.vans_back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Operation(summary = "Lisab uue juhi info driver tabelisse ning loob kasutaja ja parooli.",
    description = "Võimalus muuta roleName admin'iks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise kasutajanimega juht on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addDriver (@RequestBody )
}
