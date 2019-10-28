<%@ page import="com.mnmlyn.blog.entity.ArticleDO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.mnmlyn.blog.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="main">
    <div id="page_head">
        <h1>文章列表</h1>
    </div>
    <hr>
    <div id="article_list">
        <table id="article_list_table" border="1" width="100%">
            <tr>
                <th width="50%">题目</th>
                <th width="25%">创建日期</th>
                <th>作者</th>
            </tr>
            <%
                List<ArticleDO> articles = (List<ArticleDO>) request.getAttribute("articles");
                if (articles != null) {
                    for (ArticleDO article : articles) {
                        String title = article.getTitle();
                        String createTime = TimeUtil.getDateTimeString(article.getGmtCreate());
                        String author = article.getAuthor();
                        String articleId = article.getArticleId();
                        out.println(String.format("<tr><td><a href=" +
                                        "\"%s/m/p?aid=%s\" target=\"_blank\">%s</a></td>",
                                request.getContextPath(), articleId, title));
                        out.println(String.format("<td>%s</td>", createTime));
                        out.println(String.format("<td>%s</td></tr>", author));
                    }
                }
            %>
        </table>
    </div>
</div>