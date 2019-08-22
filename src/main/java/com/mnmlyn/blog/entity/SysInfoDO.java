package com.mnmlyn.blog.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统信息表，存储键值对
 *
 * @author mnmlyn
 * @date 2019/10/29
 */
@Getter
@Setter
public class SysInfoDO {
    private Integer id;
    private String paramKey;
    private String paramValue;
}
