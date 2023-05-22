package com.example.vans_back.domain.van;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VanMapper {

    @Mapping(source = "plateNumber", target = "vanPlateNumber")
    @Mapping(source = "insurance", target = "insurancePhoneNumber")
    @Mapping(source = "insurance", target = "insuranceProvider")
    VanBasicInfo toVanBasicInfo(Van van);
}