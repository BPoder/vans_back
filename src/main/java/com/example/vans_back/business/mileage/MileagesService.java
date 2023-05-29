package com.example.vans_back.business.mileage;

import com.example.vans_back.domain.van.mileage.Mileage;
import com.example.vans_back.business.mileage.dto.MileageDto;
import com.example.vans_back.domain.van.mileage.MileageMapper;
import com.example.vans_back.domain.van.mileage.MileageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MileagesService {

    @Resource
    private MileageService mileageService;
    @Resource
    private MileageMapper mileageMapper;

    public List<MileageDto> findAllMileageInfo(Integer vanId, Integer monthNumber, Integer yearNumber) {
        List<Mileage> mileages = mileageService.findMileageInfoByMonth(vanId, monthNumber, yearNumber);
        List<MileageDto> mileageDtos = mileageMapper.toMileageDtos(mileages);
        return mileageDtos;
    }
}
