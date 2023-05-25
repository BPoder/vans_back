package com.example.vans_back.business.van.dto;

import com.example.vans_back.domain.van.Van;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Van}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VanDto implements Serializable {
    private Integer vanId;
    @NotNull
    @Size(max = 255)
    private String vanModel;
    @NotNull
    @Size(max = 6)
    private String vanPlateNumber;
}