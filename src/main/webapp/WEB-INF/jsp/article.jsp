<%@ page import="com.mnmlyn.blog.entity.ArticleDO" %>
<%@ page import="com.mnmlyn.blog.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArticleDO articleDO = (ArticleDO) request.getAttribute("articleDO");
    String title = "null";
    String content = "null";
    String author = "null";
    String date = "null";
    if (articleDO != null) {
        title = articleDO.getTitle();
        content = articleDO.getContent();
        author = articleDO.getAuthor();
        date = TimeUtil.getDateTimeString(articleDO.getGmtCreate());
    }%>
<div id="main">
    <div id="article_title">
        <h1><%=title%>
        </h1>
    </div>
    <hr>
    <div id="article_info">
        <table id="article_info_table">
            <tr>
                <td>
                    <div id="article_create_time">
                        <%=date%>
                    </div>
                </td>
                <td>
                    <div id="article_author">
                        <%=author%>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div id="article_content">
        <div id="content">
            <%=content%>
        </div>
    </div>
</div>
