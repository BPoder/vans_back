package com.example.vans_back.business.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.business.van.dto.VanAllInfo;
import com.example.vans_back.business.van.dto.VanRequest;
import com.example.vans_back.business.van.dto.VanDto;
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
@RequestMapping("/van")
public class VansController {

    @Resource
    private VansService vansService;

    @GetMapping("all-vans")
    @Operation(summary = "Leiab süsteemist(van tabelist) kõik kaubikud",
            description = "Tagastab info koos vanId ja licencePlateNumberiga.")
    public List<VanDto> getAllVans(){
        List<VanDto> vanDtos = vansService.getAllVans();
        return vanDtos;
    }

    @GetMapping("/basic-info")
    @Operation(summary = "Tagastab driverId kaudu kaubiku reg nr ja kindlustuse info.")
    public VanBasicInfo getUserVanInfo(@RequestParam Integer driverId) {
        VanBasicInfo vanBasicInfo = vansService.getUserVanInfo(driverId);
        return vanBasicInfo;
    }

    @GetMapping("/all-info")
    @Operation(summary = "Tagastab süsteemist (andmebaasist van tabelist) kaubikute info.",
            description = "Kui cityId ja vanId on 0-id, siis tagastab kõik kaubikud.")
    public List<VanAllInfo> getVans(@RequestParam Integer cityId, @RequestParam Integer vanId) {
        List<VanAllInfo> allVans = vansService.getVans(cityId, vanId);
        return allVans;
    }

    @PostMapping
    @Operation(summary = "Lisab uue kaubiku info van tabelisse.",
            description = "Võimalus määrata kaubikule ka juht(driver).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise reg nr-iga kaubik on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addVan(@RequestBody VanRequest vanRequest) {
        vansService.addVan(vanRequest);
    }

    @DeleteMapping
    @Operation(summary = "Kustutab tabelis van rea (deaktiveerib).",
            description = "Juhi tabelis muudab vanId 'null'-iks.")
    public void deleteVan(@RequestParam Integer vanId) {
        vansService.deleteVan(vanId);
    }
}
