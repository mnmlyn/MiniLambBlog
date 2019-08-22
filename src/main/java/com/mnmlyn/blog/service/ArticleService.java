package com.mnmlyn.blog.service;

import com.github.pagehelper.PageInfo;
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

    /**
     * 根据文章类型列出文章
     *
     * @param articleType
     * @return
     */
    PageInfo<ArticleDO> listArticleSummaryByType(Integer articleType, Integer pageNo, Integer pageSize);

    /**
     * 分页列出所有的文章摘要
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<ArticleDO> listArticleSummary(Integer pageNo, Integer pageSize);

    /**
     * 插入一篇文章
     *
     * @param articleDO 文章实体
     * @return
     */
    int insertArticle(ArticleDO articleDO);
}
