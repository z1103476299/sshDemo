
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>

<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666">编辑部门</td>
    </tr>
    <tr>
        <td align="right" >
            <a href="javascript:onclick=a()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回 </a>
        </td>
    </tr>
</table>
<br/>
<br>
    <form id="saveForm" action="employee_update.action" method="post" >
        <s:hidden name="did" value="%{model.eid}"/>
        <table style="font-size:16px">
            <tr>
                <td>姓名：</td>
                <td><s:textfield name="ename" value="%{model.ename}"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><s:textfield name="gender"  value="%{model.gender}"/></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><s:textfield name="username"  value="%{model.username}"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><s:textfield name="password"  value="%{model.password}"/></td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"></td>
            </tr>
            <tr>
                <td>入职时间：</td>
                <td><input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>"></td>
            </tr>
            <tr>
                <td>编号：</td>
                <td><s:textfield name="eno" value="%{model.eno}"/></td>
            </tr>
        </table>
    </form>
    <script>
        function a() {
            var a = document.getElementById('saveForm');
            a.submit();
        }
    </script>
</body>
</html>