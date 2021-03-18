<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Login</title>
    <script type="text/javascript" src="static/jquery-3.4.1/jquery-3.4.1.min.js"></script>
</head>
<%
    //登录了直接跳转至list页面
    if (session != null && session.getAttribute("userCode") != null) {
        response.sendRedirect("list");
    }
%>
<body>
<div>
    <form id="form">
        <table style="align-content: center"><!-- 布局 -->
            <caption>登录</caption>
            <tr>
                <th scope="row"><label for="code">Code</label></th>
                <td><input type="text" id="code" name="code"></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="button" value="登录" id="login"></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    $(function () {
        $("#login").click(function () {
            $.ajax({
                url: "check",
                type: "POST",
                dataType: "text",
                data: $("#form").serialize(),
                success: function (data) {
                    if (data === "0") {
                        alert("账号或密码不正确!")
                    } else if (data === "1") {
                        window.location.href = "list";
                    }
                }
            })
        });
    })
</script>
</body>
</html>
