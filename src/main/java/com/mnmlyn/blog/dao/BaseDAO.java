package com.mnmlyn.blog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 数据访问层，抽象基类
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
public abstract class BaseDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
