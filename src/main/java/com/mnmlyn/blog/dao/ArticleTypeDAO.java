package com.mnmlyn.blog.dao;

import com.mnmlyn.blog.entity.ArticleTypeDO;

import java.util.List;

/**
 * 文章类型的数据访问接口
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
public interface ArticleTypeDAO {

    /**
     * 累出所有的文章类型
     * @return
     */
    List<ArticleTypeDO> listAllArticleType();
}
