package com.example.vans_back.business.van.dto;

import com.example.vans_back.domain.van.Van;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Van}
 */
@Value
public class VanDto implements Serializable {
    Integer vanId;
    @NotNull
    @Size(max = 255)
    String vanModel;
    @NotNull
    @Size(max = 6)
    String vanPlateNumber;
}