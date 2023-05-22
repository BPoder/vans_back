package com.example.vans_back.domain.van;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanService {

    @Resource
    private VanRepository vanRepository;

    public List<Van> getVansBy(Integer cityId, Integer vanId) {
        List<Van> vans = vanRepository.findVansBy(cityId, vanId);
        return vans;
    }
}
