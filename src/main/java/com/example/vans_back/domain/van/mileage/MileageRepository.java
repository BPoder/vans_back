package com.example.vans_back.domain.van.mileage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MileageRepository extends JpaRepository<Mileage, Integer> {


    @Query("select m from Mileage m where m.van.id = ?1 and m.date = ?2 order by m.date")
    List<Mileage> findBy(Integer id, LocalDate date);



}