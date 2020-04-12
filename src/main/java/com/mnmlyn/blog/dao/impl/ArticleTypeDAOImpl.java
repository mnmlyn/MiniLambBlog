package com.mnmlyn.blog.dao.impl;

import com.mnmlyn.blog.dao.ArticleTypeDAO;
import com.mnmlyn.blog.dao.BaseDAO;
import com.mnmlyn.blog.entity.ArticleTypeDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章类型数据访问实现
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
@Component
public class ArticleTypeDAOImpl extends BaseDAO implements ArticleTypeDAO {

    @Override
    public List<ArticleTypeDO> listAllArticleType() {
        return getSqlSessionTemplate().selectList("article_type.listAllArticleType");
    }
}
