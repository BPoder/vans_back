package com.example.vans_back.domain.van.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("select d from Driver d where d.user.id = ?1")
    Optional<Driver> findDriverByUserId(Integer userId);
    @Query("select d from Driver d where d.id = ?1")
    Optional<Driver> findDriverByDriverId(Integer driverId);

}