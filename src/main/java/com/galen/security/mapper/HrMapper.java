package com.galen.security.mapper;

import com.galen.security.pojo.SecurityUser;
import com.galen.security.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Repository
public interface HrMapper {
    SecurityUser loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);

    int hrReg(@Param("username") String username, @Param("password") String password);

    List<SecurityUser> getHrsByKeywords(@Param("keywords") String keywords);

    int updateHr(SecurityUser securityUser);

    int deleteRoleByHrId(Long hrId);

    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);

    SecurityUser getHrById(Long hrId);

    int deleteHr(Long hrId);

    List<SecurityUser> getAllHr(@Param("currentId") Long currentId);
}
