package com.mnmlyn.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mnmlyn.blog.dao.ArticleDAO;
import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章实现类
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public ArticleDO queryArticleByArticleId(String articleId) {
        return articleDAO.queryArticleByArticleId(articleId);
    }

    @Override
    public List<ArticleDO> listArticleSimple() {
        return articleDAO.listArticleSimple();
    }

    @Override
    public PageInfo<ArticleDO> listArticleSummaryByType(Integer articleType, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ArticleDO> articleList = articleDAO.listArticleSummaryByType(articleType);
        PageInfo<ArticleDO> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleDO> listArticleSummary(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ArticleDO> articleList = articleDAO.listArticleSummary();
        PageInfo<ArticleDO> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    @Override
    public int insertArticle(ArticleDO articleDO) {
        return articleDAO.insertArticle(articleDO);
    }
}
