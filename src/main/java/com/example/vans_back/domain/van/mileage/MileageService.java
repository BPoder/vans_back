package com.example.vans_back.domain.van.mileage;

import com.example.vans_back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MileageService {
    @Resource
    private MileageRepository mileageRepository;

    public List<Mileage> findMileageInfoByMonth(Integer vanId, Integer monthNumber, Integer yearNumber) {
        // Create a LocalDate object for the specified year and month
        LocalDate date = LocalDate.of(yearNumber, monthNumber, 1);

        // Find the first date of the given month
        LocalDate startDate = date.withDayOfMonth(1);

        // Find the last date of given month
        LocalDate endDate = date.plusMonths(1).minusDays(1);

      return mileageRepository.findMileagesBy(vanId, startDate, endDate);
    }

    public void addMileage(Mileage mileage) {
        mileageRepository.save(mileage);
    }

    public void validateDateIsAvailableBy(LocalDate date, Integer vanId) {
        boolean dateExists = mileageRepository.dateForVanExistsBy(date, vanId);
        ValidationService.validateDateIsAvailable(dateExists);
    }
}
