<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <style type="${pageContext.request.contextPath}/text/css">
        .div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
    </style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
    欢迎您：<s:property value="#session.existEmployee.ename" />
</div>
</body>
</html>

