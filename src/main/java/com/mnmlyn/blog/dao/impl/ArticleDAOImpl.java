package com.mnmlyn.blog.dao.impl;

import com.mnmlyn.blog.dao.ArticleDAO;
import com.mnmlyn.blog.dao.BaseDAO;
import com.mnmlyn.blog.entity.ArticleDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ArticleDAO实现类
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
@Component
public class ArticleDAOImpl extends BaseDAO implements ArticleDAO {
    @Override
    public ArticleDO queryArticleByArticleId(String articleId) {
        return getSqlSessionTemplate().selectOne("article.queryArticleByArticleId", articleId);
    }

    @Override
    public List<ArticleDO> listArticleSimple() {
        return getSqlSessionTemplate().selectList("article.listArticleSimple");
    }

    @Override
    public int insertArticle(ArticleDO articleDO) {
        return getSqlSessionTemplate().insert("article.insertArticle", articleDO);
    }
}
