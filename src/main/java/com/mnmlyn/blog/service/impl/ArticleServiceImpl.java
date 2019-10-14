package com.mnmlyn.blog.service.impl;

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
}
