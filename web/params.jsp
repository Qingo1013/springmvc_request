<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/1/22
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ti tle</title>
</head>
<body>
    <h2>简单参数演示</h2>
    <%-- 表单元素的名字要与action 调用的请求（params01）处理方法一致--%>
    <form action="${pageContext.request.contextPath}/params01" method="post">
        <%-- 表单元素的名字要与action 调用的请求（params01）处理方法一致
            因为客户端的根目录是在localhost:8080/这一级,而请求要在localhost:8080/springmvc/这一级
            所以action要等于动态获取的目录。
        --%>
    姓名：<input  name="username" type="text"><p></p>
    <input type="submit" value="提交">
    </form>


    <h2>复杂参数演示</h2>
    <%-- 表单元素的名字要与action 调用的请求（params01）处理方法一致--%>
    <form action="${pageContext.request.contextPath}/params02" method="post" >
        <%-- 表单元素的名字要与action 调用的请求（params01）处理方法一致
            因为客户端的根目录是在localhost:8080/这一级,而请求要在localhost:8080/springmvc/这一级
            所以action要等于动态获取的目录。
        --%>
    <%--
    private Integer id;
    private String name;
    private String[] alias; // 外号
    private List<String> hobbies; //爱好
    private Map<String,String> relatives; //亲属
    private Role role;
    private List<User> friends; //朋友
    --%>
        id：<input  name="user.id" type="text"><p></p>
        姓名：<input  name="user.name" type="text"><p></p>
        <%--value属性在浏览器看不到，但是value才会传到服务器--%>
        <%--当是List这样有序的数据结构时，
            List<基本数据类型> 不用加下标，如下面hobbies
            List<定义的类> 要加下标，如下面relatives
        --%>
        外号：<input  name="user.alias" type="checkbox" value="小野" checked>小野
             <input  name="user.alias" type="checkbox" value="狗剩" checked>狗剩 <p></p>
        爱好：<input  name="user.hobbies" type="checkbox" value="唱歌" checked>唱歌
        <input  name="user.hobbies" type="checkbox" value="跳舞" checked>跳舞 <p></p>
        亲属：<input  name="user.relatives['father']" type="checkbox" value="爸爸" checked>爸爸
        <input  name="user.relatives['mom']" type="checkbox" value="妈妈" checked>妈妈 <p></p>

        角色：<input  name="user.role.name" type="text" > <p></p>
        朋友：<input  name="user.friends[0].name" type="text" value="张三"> <br>
            <input  name="user.friends[1].name" type="text" value="李四"><p></p>

        <h2>新增角色</h2>
        id:<input  name="role.id" type="text" > <p></p>
        name:<input  name="role.name" type="text" > <p></p>
            <input type="submit" value="提交">
    </form>

</body>
</html>
