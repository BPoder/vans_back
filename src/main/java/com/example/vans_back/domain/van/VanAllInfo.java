package com.example.vans_back.domain.van;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Van} entity
 */
@Data
public class VanAllInfo implements Serializable {
    private Integer vanId;
    private String model;
    private String plateNumber;
    private Integer insuranceId;
    private String insuranceProvider;
    private String insurancePhoneNumber;
    private Integer cityId;
    private String cityName;
    private LocalDate nextInspection;
    private String status;
}