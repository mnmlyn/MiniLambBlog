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
<div id="detail">
    <table border="1">
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <tr>
            <td>${emp.getId()}</td>
            <td>${emp.getName()}</td>
            <td>${emp.getAge()}</td>
        </tr>
    </table>
</div>
</body>
</html>
