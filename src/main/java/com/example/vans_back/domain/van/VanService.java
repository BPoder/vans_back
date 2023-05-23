package com.example.vans_back.domain.van;

import com.example.vans_back.business.van.dto.VanAllInfo;
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

    public void addVan(Van van) {
        vanRepository.save(van);
    }
}
