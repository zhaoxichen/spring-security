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
}
