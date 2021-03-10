<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/10
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("basepath",request.getContextPath()) ; %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    <form action="${pageContext.request.contextPath}/rest/user/1" method="get">
    与下面相同
--%>
    <form action="${basepath}/rest/user/1" method="get">
        <input type="submit" value="查询">
    </form>

    <form action="${basepath}/rest/user" method="post">
        id：<input  name="id" type="text"><p></p>
        姓名：<input  name="name" type="text"><p></p>
        <input type="submit" value="新增">
    </form>
    <%--
        html不支持put、delete,但http支持
        SpringMVC框架已经定义好了如何将http设置为put/delete
        我们只需要增加一个hidden隐藏域
        例如：<input type="hidden" value="put" name="_method">
    --%>
    <form action="${basepath}/rest/user/1" method="post">
        <input type="hidden" value="put" name="_method">
        id：<input  name="id" type="text"><p></p>
        姓名：<input  name="name" type="text"><p></p>
        <input type="submit" value="修改">
    </form>

    <form action="${basepath}/rest/user/1" method="post">
        <input type="hidden" value="delete" name="_method">
        <input type="submit" value="删除">
    </form>

</body>
</html>
