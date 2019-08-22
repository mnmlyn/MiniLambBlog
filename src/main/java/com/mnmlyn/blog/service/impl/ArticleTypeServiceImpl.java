package com.mnmlyn.blog.service.impl;

import com.mnmlyn.blog.dao.ArticleTypeDAO;
import com.mnmlyn.blog.entity.ArticleTypeDO;
import com.mnmlyn.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章类型的服务
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeDAO articleTypeDAO;

    @Override
    public List<ArticleTypeDO> listAllArticleType() {
        return articleTypeDAO.listAllArticleType();
    }

    @Override
    public Map<Integer, String> getArticleTypeMap() {
        List<ArticleTypeDO> articleTypeDOS = articleTypeDAO.listAllArticleType();
        Map<Integer, String> typeMap = new HashMap<>(16);
        for (ArticleTypeDO articleTypeDO:articleTypeDOS) {
            typeMap.put(articleTypeDO.getId(), articleTypeDO.getTypeName());
        }
        return typeMap;
    }

    @Override
    public String getArticleTypeName(int type) {
        List<ArticleTypeDO> articleTypeDOS = articleTypeDAO.listAllArticleType();
        for (ArticleTypeDO articleTypeDO:articleTypeDOS) {
            if (type == articleTypeDO.getId()) {
                return articleTypeDO.getTypeName();
            }
        }
        return null;
    }

}
