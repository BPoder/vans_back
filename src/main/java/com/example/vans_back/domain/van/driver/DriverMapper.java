package com.example.vans_back.domain.van.driver;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.domain.van.Van;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {

    @Mapping(source = "van.plateNumber", target = "vanPlateNumber")
    @Mapping(source = "van.insurance.provider", target = "insuranceProvider")
    @Mapping(source = "van.insurance.phoneNumber", target = "insurancePhoneNumber")
    VanBasicInfo toVanBasicInfo(Driver driver);
}
