package com.mnmlyn.blog.dao;

import com.mnmlyn.blog.entity.ArticleDO;

import java.util.List;

/**
 * 文章的数据访问
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
public interface ArticleDAO {
    /**
     * 根据文章id，查询文章
     *
     * @param articleId
     * @return
     */
    ArticleDO queryArticleByArticleId(String articleId);

    /**
     * 列出文章简要信息，只包含以下字段
     * article_id，题目，创建日期，作者
     *
     * @return
     */
    List<ArticleDO> listArticleSimple();
}
