<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head></head>

<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 部门添加</td>
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
    <form id="saveForm" action="department_save.action" method="post" >
        <table style="font-size:16px">
            <tr>
                <td>部门名称：</td>
                <td><input type="text" name="dname"/></td>
            </tr>
            <tr>
                <td>部门介绍：</td>
                <td>
                    <textarea cols="50" rows="5" name="ddesc">
                    </textarea>
                </td>
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