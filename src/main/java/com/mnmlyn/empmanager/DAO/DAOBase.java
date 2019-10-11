package com.mnmlyn.empmanager.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DAOBase {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
