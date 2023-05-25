package com.example.vans_back.domain.van.city;

import com.example.vans_back.business.city.dto.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityDto toCityDto(City city);
    List<CityDto> toCityDtos(List<City> cities);



}