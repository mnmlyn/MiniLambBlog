package com.mnmlyn.blog.dao;

import com.mnmlyn.blog.entity.SysInfoDO;

/**
 * 系统参数表
 *
 * @author mnmlyn
 * @date 2019/10/29
 */
public interface SysInfoDAO {
    /**
     * 根据参数key值查询
     *
     * @param paramKey
     * @return
     */
    SysInfoDO querySysInfoByParamKey(String paramKey);

    /**
     * 更新参数值
     *
     * @param paramKey
     * @param paramValue
     * @return
     */
    boolean updateSysInfo(String paramKey, String paramValue);
}
