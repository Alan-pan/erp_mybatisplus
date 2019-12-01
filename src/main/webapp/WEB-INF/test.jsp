<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="shir" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>shiro test.....</h1>
    <!--当前用户的用户名-->
    <shiro:principal/>
    <shiro:hasRole name="采购经理">
        <a href="#">订单列表</a>
    </shiro:hasRole>
    <shiro:hasRole name="后台管理员">
        <a href="#">员工管理</a>
    </shiro:hasRole>
    <shiro:hasPermission name="员工管理">
        <a href="#">员工管理</a>
    </shiro:hasPermission>
</body>
</html>
