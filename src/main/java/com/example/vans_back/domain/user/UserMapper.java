package com.example.vans_back.domain.user;

import com.example.vans_back.business.driver.dto.DriverRequest;
import com.example.vans_back.business.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(constant = "A", target = "status")
    User toUser(DriverRequest driverRequest);

}