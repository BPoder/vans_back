package com.example.vans_back.business.user;

import com.example.vans_back.business.user.dto.UserDto;
import com.example.vans_back.domain.van.driver.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Resource
    private UsersService usersService;
    @GetMapping("/all-users")
    @Operation(summary = "Leiab user tabelist kõik userid",
            description = "tagastab info koos userId ja userName'ga")
    public List<UserDto> getUsers() {
        List<UserDto> users = usersService.getUsers();
        return users;
    }

}
