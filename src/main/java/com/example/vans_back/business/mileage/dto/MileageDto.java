package com.example.vans_back.business.mileage.dto;

import com.example.vans_back.domain.van.mileage.Mileage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Mileage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MileageDto implements Serializable {
    private Integer id;
    private Integer vanId;
    @NotNull
    private LocalDate date;
    @NotNull
    private Integer km;
}