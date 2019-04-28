<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/4/18
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<head>
    <title></title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand navbar-left" href="#">Brand</a>

            </div>
            <shiro:authenticated>
                <p class="navbar-text"> 你好：<shiro:principal/></p>
            </shiro:authenticated>
        </div>
    </nav>
</body>
</html>
