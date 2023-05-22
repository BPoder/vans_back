package com.example.vans_back.domain.van;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VanRepository extends JpaRepository<Van, Integer> {
    @Query("select v from Van v where (v.city.id = ?1 or ?1 = 0) and (v.id = ?2 or ?2 = 0)")
    List<Van> findVansBy(Integer cityId, Integer vanId);

}