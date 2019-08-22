package com.mnmlyn.blog.controller;

import com.mnmlyn.blog.entity.ArticleTypeDO;
import com.mnmlyn.blog.msg.BaseMsg;
import com.mnmlyn.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 文章类型控制器
 *
 * @author mnmlyn
 * @date 2020/4/4
 */
@Controller
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("/articleTypes")
    @ResponseBody
    public BaseMsg listArticleType() {
        List<ArticleTypeDO> articleTypes = articleTypeService.listAllArticleType();
        return BaseMsg.successWithData(articleTypes);
    }
}
