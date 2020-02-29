package com.mnmlyn.blog.dao.impl;

import com.mnmlyn.blog.dao.BaseDAO;
import com.mnmlyn.blog.dao.SysInfoDAO;
import com.mnmlyn.blog.entity.SysInfoDO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统参数表DAO
 *
 * @author mnmlyn
 * @date 2019/10/29
 */
@Component
public class SysInfoDAOImpl extends BaseDAO implements SysInfoDAO {
    @Override
    public SysInfoDO querySysInfoByParamKey(String paramKey) {
        return getSqlSessionTemplate().selectOne("sys_info.querySysInfoByParamKey", paramKey);
    }

    @Override
    public boolean updateSysInfo(String paramKey, String paramValue) {
        Map<String, String> map = new HashMap<>();
        map.put("paramKey", paramKey);
        map.put("paramValue", paramValue);
        int row = getSqlSessionTemplate().update("sys_info.updateSysInfo", map);
        return row > 0;
    }
}
