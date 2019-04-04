package com.galen.security.mapper;

import com.galen.security.pojo.SecurityPermission;
import com.galen.security.pojo.SecurityUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Repository
public interface UserSecurityMapper {
    /**
     * @Author: Galen
     * @Description: 查询数据库用户
     * @Date: 2019/4/4-9:09
     * @Param: [username]
     * @return: com.galen.security.pojo.SecurityUser
     **/
    SecurityUser loadUserByUsername(String username);

    /**
     * @Author: Galen
     * @Description: 获取所有的菜单
     * @Date: 2019/3/27-14:34
     * @Param: []
     * @return: java.util.List<SecurityPermission>
     **/
    List<SecurityPermission> getAllPermission();
}
