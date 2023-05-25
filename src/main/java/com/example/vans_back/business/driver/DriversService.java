package com.example.vans_back.business.driver;

import com.example.vans_back.business.driver.dto.DriverAllInfo;
import com.example.vans_back.business.driver.dto.DriverDto;
import com.example.vans_back.business.driver.dto.DriverRequest;
import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.domain.van.driver.DriverMapper;
import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriversService {

    @Resource
    private DriverService driverService;

    @Resource
    private DriverMapper driverMapper;
    public List<DriverAllInfo> getDrivers(Integer cityId, Integer driverId) {
        List<Driver> drivers = driverService.getDriversBy(cityId, driverId);
        List<DriverAllInfo> driverAllInfos = driverMapper.toDriverAllInfos(drivers);
        return driverAllInfos;
    }

    public void addDriver(DriverRequest driverRequest) {

//         todo: peame looma Mapperi abil Driver objekti, salvestada seda veel ei saa

//         todo: peame cityId abil üles leidma City objekti ja peame driverile set-iga külge panema selle City,

//         todo: peame looma Mapperi abil User objekti,
//          peame roleId abil üles leidma Role objekti ja panema selle User objektile set-iga külge,
//          peame useri andmebaasi ära salvestana userRep save,

//         todo: nüüd peame driverile set-iga külge panema selle useri,
//          nüüd saame driveri salvestada andmebaasi,
//
//        @Mapping(source = "userRoleId", target = "id")
//        @Mapping(source = "username", target = "user.username")
//        @Mapping(source = "password", target = "user.password")
    }

    public List<DriverDto> findAllDrivers() {
        List<Driver> drivers = driverService.findAllActiveDrivers();
        List<DriverDto> driverDtos = driverMapper.toDriverDtos(drivers);
        return driverDtos;

    }
}
