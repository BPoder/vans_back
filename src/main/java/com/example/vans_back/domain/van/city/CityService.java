package com.example.vans_back.domain.van.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public City getCityBy(Integer cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        City city = cityOptional.get();
        return city;
    }

    public List<City> getCities() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }
}
