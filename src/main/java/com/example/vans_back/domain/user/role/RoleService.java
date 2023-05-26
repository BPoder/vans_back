package com.example.vans_back.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role getRoleBy(Integer roleId) {
        return roleRepository.findById(roleId).get();
    }
}
