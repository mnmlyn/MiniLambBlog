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
    public List<ArticleDO> listArticleSummaryByType(Integer type) {
        return getSqlSessionTemplate().selectList("article.listArticleSummaryByType", type);
    }

    @Override
    public List<ArticleDO> listArticleSummary() {
        return getSqlSessionTemplate().selectList("article.listArticleSummary");
    }

    @Override
    public int queryMaxArticleId() {
        Integer maxArticleId = getSqlSessionTemplate().selectOne("article.queryMaxArticleId");
        return maxArticleId == null ? 0 : maxArticleId;
    }

    @Override
    public int insertArticle(ArticleDO articleDO) {
        if (articleDO.getArticleId() == null) {
            int articleId = queryMaxArticleId() + 1;
            System.out.println("新的id为"+ articleId);
            articleDO.setArticleId(articleId);
        }
        getSqlSessionTemplate().insert("article.insertArticle", articleDO);
        return articleDO.getArticleId();
    }
}
