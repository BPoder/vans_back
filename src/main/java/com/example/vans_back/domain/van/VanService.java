package com.example.vans_back.domain.van;

import com.example.vans_back.business.Status;
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

    public void deactivateVan(Integer vanId) {
        Van van = vanRepository.findById(vanId).get();
        van.setStatus(Status.DELETED.getLetter());
        vanRepository.save(van);
    }

    public List<Van> getAllVans() {
        List<Van> vans = vanRepository.findAll();
        return vans;
    }
}
