package com.mnmlyn.blog.service;

import com.mnmlyn.blog.entity.ArticleTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 文章类型的服务
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
public interface ArticleTypeService {

    /**
     * 列出所有的文章类型
     * @return
     */
    List<ArticleTypeDO> listAllArticleType();

    /**
     * 获取文章类型的Map
     * @return
     */
    Map<Integer, String> getArticleTypeMap();

    /**
     * 根据类型编号，获取文章类型名称
     * @param type
     * @return 未找到返回null
     */
    String getArticleTypeName(int type);
}
