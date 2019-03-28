package com.galen.security.service;

import com.galen.security.pojo.SecurityUser;
import com.galen.security.common.HrUtils;
import com.galen.security.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    /**
     * @Author: Galen
     * @Description: 实现了UserDetailsService接口中的loadUserByUsername方法
     * 执行登录,构建Authentication对象必须的信息,
     * 如果用户不存在，则抛出UsernameNotFoundException异常
     * @Date: 2019/3/27-16:04
     * @Param: [s]
     * @return: org.springframework.security.core.userdetails.UserDetails
     **/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /**
         * @Author: Galen
         * @Description: 查询数据库，获取登录的用户信息
         **/
        SecurityUser securityUser = hrMapper.loadUserByUsername(s);
        if (securityUser == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return securityUser;
    }

    public int hrReg(String username, String password) {
        /**
         * 如果用户名已经存在，返回错误
         */
        if (hrMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //密码需要使用 BCrypt 加密
        String encode = encoder.encode(password);
        return hrMapper.hrReg(username, encode);
    }

    public List<SecurityUser> getHrsByKeywords(String keywords) {
        return hrMapper.getHrsByKeywords(keywords);
    }

    public int updateHr(SecurityUser securityUser) {
        return hrMapper.updateHr(securityUser);
    }

    public int updateHrRoles(Long hrId, Long[] rids) {
        int i = hrMapper.deleteRoleByHrId(hrId);
        return hrMapper.addRolesForHr(hrId, rids);
    }

    public SecurityUser getHrById(Long hrId) {
        return hrMapper.getHrById(hrId);
    }

    public int deleteHr(Long hrId) {
        return hrMapper.deleteHr(hrId);
    }

    public List<SecurityUser> getAllHrExceptAdmin() {
        return hrMapper.getAllHr(HrUtils.getCurrentHr().getId());
    }

    public List<SecurityUser> getAllHr() {
        return hrMapper.getAllHr(null);
    }
}
