package com.carry.dao.provider;

import com.carry.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProviderMapper {

    //查询用户总数，以实现供应商列表分页功能
    int getProviderCount(@Param("proName") String proName, @Param("proCode") String proCode);
    //通过供应商名称、编码获取供应商列表-模糊查询-providerList
    List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode") String proCode);//, @Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize

    //增加供应商 供应商管理模块中的子模块：添加供应商
    int add(Provider provider);

    //通过proId删除Provider
    int deleteProviderById(Integer delId);

    //通过proId获取Provider
    Provider getProviderById(int id);

    //修改用户信息
    int modify(Provider provider);
}
