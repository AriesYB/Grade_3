<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>UserList</title>
    <script type="text/javascript" src="static/jquery-3.4.1/jquery-3.4.1.min.js"></script>
</head>
<body>
<div>
    <h4>当前账号：<tags:user userName="${sessionScope.user.name}"/></h4>
    <h2>当前在线人数：${applicationScope.users.size()}</h2>
    <h2>在线用户列表</h2>
    <table border="1">
        <caption>在线用户列表</caption>
        <thead>
        <tr>
            <th scope="row">ID</th>
            <th scope="row">姓名</th>
            <th scope="row">账号</th>
            <th scope="row">密码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.code}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>离线用户列表 <input type="button" value="添加" id="add"></h2>
    <table border="1">
        <caption>离线用户列表</caption>
        <thead>
        <tr>
            <th scope="row">ID</th>
            <th scope="row">姓名</th>
            <th scope="row">账号</th>
            <th scope="row">密码</th>
            <th scope="row" colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${others}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.code}</td>
                <td>${user.password}</td>
                <td>
                    <input class="change" type="button" value="修改" id="${user.id}" data-code="${user.code}"
                           data-name="${user.name}"
                           data-password="${user.password}"></button>
                </td>
                <td><input class="delete" type="button" value="删除" data-id="${user.id}" data-name="$${user.name}"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="change" style="display: none">
        <h2>修改信息</h2>
        <form>
            <table border="1">
                <caption>用户信息</caption>
                <tr>
                    <th scope="row"><label>ID:</label><label id="id"></label></th>
                </tr>
                <tr>
                    <td><label>账号:</label><label id="code"></label></td>
                </tr>
                <tr>
                    <td><label>姓名:</label><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td><label>密码:</label><input type="text" name="password" id="password"></td>
                </tr>
                <tr>
                    <td><input type="button" value="确认修改" id="confirm"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="addDiv" style="display: none">
        <h2>添加用户</h2>
        <form>
            <table border="1">
                <caption>添加用户</caption>
                <tr>
                    <th scope="row"><label>ID:</label><input type="text" name="id" id="add-id"></th>
                </tr>
                <tr>
                    <td><label>账号:</label><input type="text" name="code" id="add-code"></td>
                </tr>
                <tr>
                    <td><label>姓名:</label><input type="text" name="name" id="add-name"></td>
                </tr>
                <tr>
                    <td><label>密码:</label><input type="text" name="password" id="add-password"></td>
                </tr>
                <tr>
                    <td><input type="button" value="确认添加" id="confirmAdd"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var userId;
        $(".change").click(function () {
            $("#addDiv").css("display", "none");
            userId = this.id
            $("#change").css("display", "block");
            $("#id").text(userId);
            $("#code").text($(this).data("code"));
            $("#name").val($(this).data("name"))
            $("#password").val($(this).data("password"));
        });
        $("#confirm").click(function () {
            let r = confirm("确定修改吗?")
            if (r == false) {
                return
            }
            $.ajax({
                url: "update",
                type: "POST",
                dataType: "text",
                data: $("form").serialize() + "&id=" + userId + "&code=" + $("#code").text(),
                success: function (data) {
                    if (data === "1") {
                        alert("修改成功!")
                        window.location.href = "list";
                    } else if (data === "0") {
                        alert("修改失败!")
                    }
                }
            })
        });
        $(".delete").click(function () {
            let r = confirm("确定删除" + $(this).data("name") + "吗?")
            if (r == false) {
                return
            }
            $.ajax({
                url: "delete",
                type: "POST",
                dataType: "text",
                data: "id=" + $(this).data("id"),
                success: function (data) {
                    if (data === "1") {
                        alert("删除成功!")
                        window.location.href = "list";
                    } else if (data === "0") {
                        alert("删除失败!")
                    }
                }
            })
        });

        $("#add").click(function () {
            $("#change").css("display", "none");
            $("#addDiv").css("display", "block");
        })
        $("#confirmAdd").click(function () {
            let r = confirm("确认添加" + $("#add-name").val() + "吗?")
            if (r == false) {
                return
            }
            $.ajax({
                url: "add",
                type: "POST",
                dataType: "text",
                data: "id=" + $("#add-id").val() + "&code=" + $("#add-code").val() + "&name=" + $("#add-name").val() + "&password=" + $("#add-password").val(),
                success: function (data) {
                    if (data === "1") {
                        alert("添加成功!")
                        window.location.href = "list";
                    } else if (data === "0") {
                        alert("添加失败!")
                    }
                }
            })

        })
    })
</script>
</body>
</html>
