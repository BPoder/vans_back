package com.example.vans_back.business.driver.dto;

import com.example.vans_back.domain.van.driver.Driver;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Driver}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto implements Serializable {
    private Integer driverId;
    private String driverName;
}