package com.mnmlyn.blog.controller;

import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于处理文章相关数据
 *
 * @author mnmlyn
 * @date 2020/3/25
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/check")
    @ResponseBody
    public String test() {
        return "Hello, 你好！";
    }

    @RequestMapping("/article/{articleId}")
    @ResponseBody
    public ArticleDO getArticle(@PathVariable String articleId) {
        ArticleDO articleDO = articleService.queryArticleByArticleId(articleId);
        articleDO.setAuthor("中文");
        return articleDO;
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insertArticle() {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setArticleId("3");
        articleDO.setTitle("mybatis 插入");
        articleDO.setAuthor("自动产生");
        articleDO.setContent("xxxxxx<>mifm34%^%)&*GO^*GOUBL>JBIL哈哈哈哈或");
        articleDO.setState(1);
        return articleService.insertArticle(articleDO);
    }

}
