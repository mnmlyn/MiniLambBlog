package com.mnmlyn.blog.servlet;

import com.mnmlyn.blog.entity.ArticleDO;
import com.mnmlyn.blog.service.ArticleService;
import com.mnmlyn.blog.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 主分发Servlet
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
public class OldDispatchServlet extends HttpServlet {

    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = UrlUtil.getRequestURI(req.getRequestURI(), req.getContextPath(), req.getServletPath());
        System.out.println(uri);

        String dispatcherPath = null;

        if ("p".equals(uri)) {
            ArticleDO article = null;
            String aid = req.getParameter("aid");
            String about = req.getParameter("about");
            if (about != null) {
                aid = "about";
            }
            if (!StringUtils.isEmpty(aid) && isAid(aid)) {
                article = articleService.queryArticleByArticleId(aid);
            }
            if (article != null) {
                dispatcherPath = "/WEB-INF/jsp/view.jsp";
                req.setAttribute("articleDO", article);
                req.setAttribute("__page__", "article");
            } else {
                dispatcherPath = "/WEB-INF/jsp/404.jsp";
            }
        } else if ("list".equals(uri)) {
            dispatcherPath = "/WEB-INF/jsp/view.jsp";
            req.setAttribute("__page__", "article_list");
            List<ArticleDO> articles = articleService.listArticleSimple();
            req.setAttribute("articles", articles);
        } else if ("check".equals(uri)) {
            resp.getWriter().println("dispatch ok");
        } else {
            dispatcherPath = "/WEB-INF/jsp/404.jsp";
        }

        if (dispatcherPath != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherPath);
            dispatcher.forward(req, resp);
        }

        System.out.println("dispatch ok");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    private static boolean isAid(String aid) {
        if (aid == null) return false;
        return aid.matches("[0-9]+") || "about".equals(aid);
    }

}
