package com.mnmlyn.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.model.BlogModel;
import com.mnmlyn.blog.service.ArticleService;
import com.mnmlyn.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 主页
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false, defaultValue = "1") String p) {
        int pageNo = Integer.parseInt(p);
        PageInfo<ArticleDO> articleDOPageInfo = articleService.listArticleSummary(pageNo, 10);
        new BlogModel(model).addNavIndex(0)
                .addArticlePageInfo(articleDOPageInfo)
                .addHeadlineInfo("最新发布")
                .addArticleTypeMap(articleTypeService.getArticleTypeMap());

        return "classify";
    }
}
