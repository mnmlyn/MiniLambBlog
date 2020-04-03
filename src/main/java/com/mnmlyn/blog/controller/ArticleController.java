package com.mnmlyn.blog.controller;

import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.msg.BaseMsg;
import com.mnmlyn.blog.service.ArticleService;
import com.mnmlyn.blog.util.ParamValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;

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

    @RequestMapping("/json/article/{articleId}")
    @ResponseBody
    public ArticleDO getArticle(@PathVariable String articleId) {
        ArticleDO articleDO = articleService.queryArticleByArticleId(articleId);
        articleDO.setAuthor("中文");
        return articleDO;
    }

    @RequestMapping("/article/{articleId}")
    public String testJsp(Model model, @PathVariable String articleId) {
        ArticleDO articleDO = articleService.queryArticleByArticleId(articleId);
        model.addAttribute("article", articleDO);
        return "detail";
    }

    @RequestMapping("/editor")
    public String editor(Model model) {
        model.addAttribute("randomKey", Integer.toString(new Random().nextInt(9000)+1000));
        return "editor";
    }

    @RequestMapping(value="insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg insertArticle(HttpServletRequest request) {
        String md = request.getParameter("md");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String isDraft = request.getParameter("isDraft");
        String postKey = request.getParameter("postKey");
        String getKey = request.getParameter("getKey");

        String errMsg = null;
        HashMap<String, String> params = new HashMap<>();
        params.put("md", md);
        params.put("content", content);
        params.put("title", title);
        params.put("isDraft", isDraft);
        params.put("postKey", postKey);
        params.put("getKey", getKey);
        errMsg = ParamValidateUtil.paramEmptyValidate(params);

        int state = 0;
        if (errMsg == null) {
            if ("true".equalsIgnoreCase(isDraft)) {
                state = 0;
            } else if ("false".equalsIgnoreCase(isDraft)) {
                state = 1;
            } else {
                errMsg = "state错误";
            }
        }
        int articleId = -1;
        if (errMsg == null) {
            ArticleDO articleDO = new ArticleDO();
            articleDO.setTitle(title);
            articleDO.setAuthor("测试test");
            articleDO.setContent(content);
            articleDO.setState(state);
            try {
                articleId = articleService.insertArticle(articleDO);
            } catch (Exception e) {
                e.printStackTrace();
                errMsg = "发表出现错误";
            }
        }
        if (errMsg == null) {
            return BaseMsg.successWithData(articleId);
        } else {
            return BaseMsg.fail(-400, errMsg);
        }
    }

}
