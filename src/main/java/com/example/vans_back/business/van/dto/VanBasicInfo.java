package com.example.vans_back.business.van.dto;

import com.example.vans_back.domain.van.Van;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Van} entity
 */
@Data
public class VanBasicInfo implements Serializable {

    private String vanPlateNumber;
    private String insuranceProvider;
    private String insurancePhoneNumber;
}