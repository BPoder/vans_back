package com.example.vans_back.domain.van.mileage;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class MileageService {
    @Resource
    private MileageRepository mileageRepository;

    public List<Mileage> findAllMileageInfo(Integer vanId, LocalDate date) {
        List<Mileage> mileages = mileageRepository.findBy(vanId, date);
        return mileages;

    }
}
