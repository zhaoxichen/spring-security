package com.galen.security.service.impl;

import com.galen.security.common.HrUtils;
import com.galen.security.mapper.MenuMapper;
import com.galen.security.pojo.Menu;
import com.galen.security.pojo.RespBean;
import com.galen.security.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    @Override
    public RespBean createPermission(Menu menu) {
        return null;
    }

    @Override
    public RespBean addToPermission(Long roleId, Long menuId) {
        return null;
    }

}
