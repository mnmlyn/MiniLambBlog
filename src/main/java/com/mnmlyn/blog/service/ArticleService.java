package com.mnmlyn.blog.service;

import com.mnmlyn.blog.entity.ArticleDO;

import java.util.List;

/**
 * 博客文章
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
public interface ArticleService {
    /**
     * 获取一篇博客文章
     *
     * @return 文章
     */
    ArticleDO queryArticleByArticleId(String articleId);

    /**
     * 列出文章简要信息
     *
     * @return
     */
    List<ArticleDO> listArticleSimple();
}
