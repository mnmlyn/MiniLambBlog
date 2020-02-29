package com.mnmlyn.blog.service.impl;

import com.mnmlyn.blog.dao.SysInfoDAO;
import com.mnmlyn.blog.entity.SysInfoDO;
import com.mnmlyn.blog.service.SysInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统参数相关服务
 *
 * @author mnmlyn
 * @date 2019/10/29
 */
@Service
public class SysInfoServiceImpl implements SysInfoService {

    @Resource
    private SysInfoDAO sysInfoDAO;

    @Override
    public SysInfoDO querySysInfoByParamKey(String paramKey) {
        return sysInfoDAO.querySysInfoByParamKey(paramKey);
    }

    @Override
    public boolean updateSysInfo(String paramKey, String paramValue) {
        return sysInfoDAO.updateSysInfo(paramKey, paramValue);
    }
}
