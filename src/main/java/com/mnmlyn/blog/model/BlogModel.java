package com.mnmlyn.blog.model;

import com.mnmlyn.blog.entity.ArticleDO;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;

import java.util.Map;

/**
 * 更方便地设置固定字段名称的Model参数
 *
 * @author mnmlyn
 * @date 2020/4/12
 */
public class BlogModel {
    private Model model;

    public BlogModel(Model model) {
        this.model = model;
    }

    /**
     * 文章类型名称
     */
    public BlogModel addArticleTypeName(String articleTypeName) {
        this.model.addAttribute("articleTypeName", articleTypeName);
        this.model.addAttribute("headlineInfo", "分类：" + articleTypeName);
        return this;
    }

    /**
     * 当前文章类型
     */
    public BlogModel addArticleType(Integer articleType) {
        this.model.addAttribute("articleType", articleType);
        return this;
    }

    /**
     * 页面小标题名称，添加类型名称或tag名称时，会覆盖
     */
    public BlogModel addHeadlineInfo(String headlineInfo) {
        this.model.addAttribute("headlineInfo", headlineInfo);
        return this;
    }

    /**
     * 顶部导航栏高亮的序号，首页为0，其余顺延。传入-1或不传入，代表不指定高亮
     */
    public BlogModel addNavIndex(Integer navIndex) {
        this.model.addAttribute("navIndex", navIndex);
        return this;
    }

    /**
     * 添加文章分页信息，包含文章摘要信息
     */
    public BlogModel addArticlePageInfo(@Nullable Object articlePageInfo) {
        this.model.addAttribute("articlePageInfo", articlePageInfo);
        return this;
    }

    /**
     * 添加文章类型Map
     */
    public BlogModel addArticleTypeMap(Map<Integer, String> articleTypeMap) {
        this.model.addAttribute("articleTypeMap", articleTypeMap);
        return this;
    }

    /**
     * 添加文章实体
     */
    public BlogModel addArticleDO(ArticleDO articleDO) {
        this.model.addAttribute("article", articleDO);
        return this;
    }
}
