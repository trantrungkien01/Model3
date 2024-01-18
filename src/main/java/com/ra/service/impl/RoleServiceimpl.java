package com.ra.service.imlp;


import com.ra.model.entity.Role;
import com.ra.repository.IRoleRipository;
import com.ra.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceimpl implements IRoleService {
    @Autowired
    private IRoleRipository iRoleRipository;
    @Override
    public Role findByName(String roleName) {
        return null;
    }
}