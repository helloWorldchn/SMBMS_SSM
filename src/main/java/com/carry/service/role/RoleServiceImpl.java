package com.carry.service.role;

import com.carry.dao.role.RoleMapper;
import com.carry.pojo.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    //引入Dao
    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    @Test
    public void test(){
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role:roleList){
            System.out.println(role.getRoleName());
        }
    }
}
