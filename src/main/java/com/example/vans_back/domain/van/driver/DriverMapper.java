package com.example.vans_back.domain.van.driver;

import com.example.vans_back.business.van.dto.VanBasicInfo;
import com.example.vans_back.domain.van.Van;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {

    @Mapping(source = "van.plateNumber", target = "vanPlateNumber")
    @Mapping(source = "van.insurance.provider", target = "insuranceProvider")
    @Mapping(source = "van.insurance.phoneNumber", target = "insurancePhoneNumber")
    VanBasicInfo toVanBasicInfo(Driver driver);

    @Mapping(source = "id", target = "driverId")
    @Mapping(source = "name", target = "driverName")
    @Mapping(source = "phoneNumber", target = "driverPhoneNumber")
    @Mapping(source = "license", target = "driversLicense")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.password", target = "userPassword")
    @Mapping(source = "van.city.name", target = "cityName")
    DriverAllInfo toDriverAllInfo(Driver driver);
    List<DriverAllInfo> toDriverAllInfos(List<Driver> drivers);
}
