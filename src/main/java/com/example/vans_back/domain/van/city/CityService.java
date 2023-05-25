package com.example.vans_back.domain.van.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public City findCityBy(Integer cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        City city = cityOptional.get();
        return city;
    }
}
