package com.galen.security.mapper;

import com.galen.security.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Repository
public interface MenuMapper {
    /**
     * @Author: Galen
     * @Description: 获取所有的菜单
     * @Date: 2019/3/27-14:34
     * @Param: []
     * @return: java.util.List<Menu>
     **/
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
