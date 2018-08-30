
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
    <form id="saveForm" action="department_update.action" method="post" >
        <s:hidden name="did" value="%{model.did}"/>
        <table style="font-size:16px">
            <tr>
                <td>部门名称：</td>
                <td><s:textfield name="dname" value="%{model.daname}"/></td>
            </tr>
            <tr>
                <td>部门介绍：</td>
                <td>
                    <s:textarea cols="50" rows="5" name="ddesc" value="%{model.ddesc}" />
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