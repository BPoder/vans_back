package com.example.vans_back.business.mileage;

import com.example.vans_back.business.mileage.dto.MileageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mileage")
public class MileagesController {

    @Resource
    private MileagesService mileagesService;

    @GetMapping("/all-info")
    @Operation(summary = "Tagastab kilometraazi")
    public List<MileageDto> findAllMileageInfo(@RequestParam Integer vanId, @RequestParam Integer monthNumber, @RequestParam Integer yearNumber) {
        List<MileageDto> mileages = mileagesService.findAllMileageInfo(vanId, monthNumber, yearNumber);
        return mileages;
    }
}
