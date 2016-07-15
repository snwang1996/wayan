<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>支付成功！</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/erst/views/common.css">
    <link rel="stylesheet" href="/erst/views/movieinfo/movieinfo.css">
<body class="home affix" data-spy="affix" data-offset-top="30">
    <nav class="navbar navbar-static">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand">蛙眼</a>
            </div>
            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a>${userName }</a>
                    </li>
                    <li>
                        <a href="." class="button smooth scroll hidden-xs">注销</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <section id="features">
        <h1>支付成功！</h1>
        <form action="return.ha" method="post">
            <button type="submit" class="button full col-md-offset-4">返回主页</button>
        </form>
    </section>
    

</body>