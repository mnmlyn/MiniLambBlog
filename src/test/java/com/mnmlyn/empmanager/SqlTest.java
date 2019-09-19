package com.mnmlyn.empmanager;

import com.mnmlyn.empmanager.entry.EmpDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SqlTest {

    @Test
    public void mybatisTest() throws IOException {
        // 读取配置文件
        String filename = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(filename);

        // 构建session
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmpDO empDO = sqlSession.selectOne("emp.selectEmp", 1);
            System.out.println(empDO);
        } finally {
            sqlSession.close();
        }
    }
}
