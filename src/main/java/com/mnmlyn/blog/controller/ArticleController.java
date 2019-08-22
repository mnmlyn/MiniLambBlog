package com.mnmlyn.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.model.BlogModel;
import com.mnmlyn.blog.msg.BaseMsg;
import com.mnmlyn.blog.service.ArticleService;
import com.mnmlyn.blog.service.ArticleTypeService;
import com.mnmlyn.blog.util.ParamValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("/check")
    @ResponseBody
    public String test() {
        return "Hello, 你好！";
    }

    @RequestMapping("/json/article/{articleId}")
    @ResponseBody
    public ArticleDO getArticle(@PathVariable String articleId) {
        ArticleDO articleDO = articleService.queryArticleByArticleId(articleId);
        return articleDO;
    }

    @RequestMapping("/type/{articleTypeStr}")
    public String getArticleType(Model model, @PathVariable String articleTypeStr,
                                              @RequestParam(required = false, defaultValue = "1") String p) {
        int articleType = Integer.parseInt(articleTypeStr);
        int pageNo = Integer.parseInt(p);
        PageInfo<ArticleDO> articleDOPageInfo = articleService.listArticleSummaryByType(articleType, pageNo, 10);
        new BlogModel(model).addArticleType(articleType)
                .addArticleTypeName(articleTypeService.getArticleTypeName(articleType))
                .addArticlePageInfo(articleDOPageInfo)
                .addArticleTypeMap(articleTypeService.getArticleTypeMap());
        return "classify";
    }

    @RequestMapping("/article/{articleId}")
    public String detailArticle(Model model, @PathVariable String articleId) {
        ArticleDO articleDO = articleService.queryArticleByArticleId(articleId);
        new BlogModel(model).addArticleDO(articleDO).
                addArticleTypeName(articleTypeService.getArticleTypeName(articleDO.getType()));
        return "detail";
    }

    @RequestMapping("/editor")
    public String editor(Model model) {
        model.addAttribute("randomKey", Integer.toString(new Random().nextInt(9000) + 1000));
        return "editor";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg insertArticle(HttpServletRequest request) {
        String md = request.getParameter("md");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String isDraft = request.getParameter("isDraft");
        String postKey = request.getParameter("postKey");
        String getKey = request.getParameter("getKey");
        String articleTypeStr = request.getParameter("articleType");
        String summary = request.getParameter("summary");

        String errMsg = null;
        HashMap<String, String> params = new HashMap<>();
        params.put("md", md);
        params.put("content", content);
        params.put("title", title);
        params.put("isDraft", isDraft);
        params.put("postKey", postKey);
        params.put("getKey", getKey);
        params.put("articleTypeStr", articleTypeStr);
        params.put("summary", summary);
        errMsg = ParamValidateUtil.paramEmptyValidate(params);

        int articleType = Integer.parseInt(articleTypeStr);
        int state = 0;
        if (errMsg == null) {
            if ("true".equalsIgnoreCase(isDraft)) {
                state = 0;
                articleType = 0;
            } else if ("false".equalsIgnoreCase(isDraft)) {
                state = 1;
                if (articleType == 0) {
                    errMsg = "文章必须指定分类";
                }
            } else {
                errMsg = "state错误";
            }
        }

        int articleId = -1;
        if (errMsg == null) {
            ArticleDO articleDO = new ArticleDO();
            articleDO.setTitle(title);
            articleDO.setAuthor("羊羔");
            articleDO.setMdContent(md);
            articleDO.setContent(content);
            articleDO.setState(state);
            articleDO.setType(articleType);
            articleDO.setSummary(summary);
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
