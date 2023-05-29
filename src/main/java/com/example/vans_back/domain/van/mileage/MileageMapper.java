package com.example.vans_back.domain.van.mileage;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MileageMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "van.id", target = "vanId")
    @Mapping(source = "km", target = "km")
    MileageDto toMileageDto(Mileage mileage);

    List<MileageDto> toMileageDtos(List<Mileage> mileages);
}