<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<div class="topnav">
    <a class="active_nav" href="#">Home</a>
    <a href="<%=path%>/m/list">列表</a>
    <a href="#">分类</a>
    <a href="<%=path%>/m/p?about">关于我</a>
</div>
