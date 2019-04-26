package com.galen.security.mapper;

import com.galen.security.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    /**
     * @Author: Galen
     * @Description: 查看是否已经存在
     * @Date: 2019/4/12-16:11
     * @Param: [userId, roleId]
     * @return: com.galen.security.model.SysUserRole
     **/
    SysUserRole selectByUidRid(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * @Author: Galen
     * @Description: 删除关联数据
     * @Date: 2019/4/20-14:24
     * @Param: [roleId]
     * @return: int
     **/
    int deleteByRoleId(Long roleId);

    /**
     * @Author: Galen
     * @Description: 查询与此角色关联的用户
     * @Date: 2019/4/25-11:23
     * @Param: [roleId]
     * @return: java.util.List<java.lang.Long>
     **/
    List<Long> selectUserByRid(Long roleId);
}