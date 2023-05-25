package com.example.vans_back.business.city.dto;

import com.example.vans_back.domain.van.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data

@Value
public class CityDto implements Serializable {
    Integer cityId;
    @NotNull
    @Size(max = 50)
    String cityName;
}