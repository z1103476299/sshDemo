<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head></head>

<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 员工添加</td>
    </tr>
    <tr>
        <td align="right" >
            <a href="javascript:onclick=a()" style="text-decoration: none">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)" style="text-decoration: none">退回 </a>
        </td>
    </tr>
</table>
<br/>
<br>
    <form id="saveForm" action="employee_save.action" method="post" >
        <table style="font-size:16px">
            <tr>
                <td>员工名称：</td>
                <td><input type="text" name="ename"/></td>
            </tr>
            <tr>
                <td>员工性别：</td>
                <td><input type="text" name="gender"/></td>
            </tr>
            <tr>
                <td>员工生日：</td>
                <td><input type="text" name="birthday"/></td>
            </tr>
            <tr>
                <td>员工入职时间：</td>
                <td><input type="text" name="joinDate"/></td>
            </tr>
            <tr>
                <td>员工编号：</td>
                <td><input type="text" name="eno"/></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password"/></td>
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