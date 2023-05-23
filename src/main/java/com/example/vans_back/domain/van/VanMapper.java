package com.example.vans_back.domain.van;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VanMapper {

    @Mapping(source = "id", target = "vanId")
    @Mapping(source = "plateNumber", target = "plateNumber")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "nextInspection", target = "nextInspection")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "insurance.id", target = "insuranceId")
    @Mapping(source = "insurance.provider", target = "insuranceProvider")
    @Mapping(source = "insurance.phoneNumber", target = "insurancePhoneNumber")
    VanAllInfo toVanAllInfo(Van van);


    List<VanAllInfo> toVanAllInfos(List<Van> vans);
}