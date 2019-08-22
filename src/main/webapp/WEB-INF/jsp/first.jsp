<%@ page import="com.mnmlyn.empmanager.entry.EmpDO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>员工信息</title>
</head>
<body>
<div id="title">
    <h1>员工信息</h1>
</div>
<hr>
<div>
    <a href="<%=request.getContextPath()%>/insert.html">插入新员工</a>
</div>
<div id="detail">
    <table border="1">
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <%
            List<EmpDO> empList = (List<EmpDO>) request.getAttribute("empList");
            if (empList != null) {
                for (EmpDO emp : empList) {
                    out.println("<tr>");
                    out.println("<td>" + emp.getId() + "</td>");
                    out.println("<td>" + emp.getName() + "</td>");
                    out.println("<td>" + emp.getAge() + "</td>");
                    out.println("<td><a href=\"" + request.getContextPath()
                            +  "/s/delete?id="
                            + emp.getId() + "\">开除</a></td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
</div>
</body>
</html>
