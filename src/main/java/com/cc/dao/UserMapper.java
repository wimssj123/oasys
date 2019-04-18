package com.cc.dao;

import com.cc.entity.Role;
import com.cc.entity.User;
import com.cc.vo.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public List<VUser> findAllByPage(@Param("page") int page,@Param("limit") int limit,@Param("no") String no,@Param("flag") String flag);

    public List<VUser> findAllManage(String name);

    public List<String> findRoleByName(String name);

    public List<String> findPermisionByName(String name);

    public List<Role> findRoleById(int id);

    public List<VUser> selectAll(@Param("no") String no,@Param("flag") String flag);

}