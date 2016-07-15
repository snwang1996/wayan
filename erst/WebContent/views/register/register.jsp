<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/erst/views/common.css" />
    <link rel="stylesheet" type="text/css" href="/erst/views/register/register.css" />


</head>

<body class="login form overlay background affix-top" data-spy="affix" data-offset-top="30">
    <nav class="navbar navbar-static">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/erst/index.jsp">蛙眼</a>
            </div>
            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="login.ha">登录</a></li>
                    <li>
                        <a href="register.ha" class="button smooth scroll hidden-xs">创建账号</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="modal" tabindex="-1" role="dialog" aria-labelledby="formLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form id="form" method="post" action="registering.ha" class="modal-content" data-parsley-validate="true" data-parsley-ui-enabled="false">
                <div class="modal-header text-center">
                    <h1 class="modal-title" id="formModalLabel">注册</h1>
                </div>
                <div class="modal-body">
                    <input type="email" required="true" name="email" placeholder="电子邮箱" class="input-bare" data-parsley-trigger="focusout">
                    <input type="text" required="true" name="nickname" placeholder="昵称" class="input-bare" data-parsley-trigger="focusout">
                    <input type="password" required="true" name="password" placeholder="密码" class="input-bare" data-parsley-trigger="focusout" >
                </div>
                <div class="modal-footer">
                    <button id="submit" type="submit" class="button full block">创建账号</button>
                    <div style="color:red; margin-top:10px">${registerWarning }</div>
                    <a class="text-center" href="login.ha">已有账号？登录</a>
                </div>
            </form>
        </div>
    </div>

<script src="/erst/views/jquery.js"></script>
<script src="/erst/views/register/register.js"></script>


</body>
</html>