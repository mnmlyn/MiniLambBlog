<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
    <title>文章列表-myblog</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/blog.css">
</head>
<body>
<jsp:include page="tophead.jsp"/>
<jsp:include page="topnav.jsp"/>

<div class="content">
    <div class="row">
        <jsp:include page="leftside.jsp"/>
        <div class="main">
            <div class="middle">
                <div class="card">
                    <%
                    String dispatchPage = (String)request.getAttribute("__page__");
                    if(!StringUtils.isEmpty(dispatchPage)) {
                        switch(dispatchPage) {
                            case "article":
                                %><jsp:include page="article.jsp"/><%
                                break;
                            case "article_list":
                                %><jsp:include page="article_list.jsp"/><%
                                break;
                        }
                    }
                    %>
                </div>
            </div>

            <jsp:include page="rightside.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

