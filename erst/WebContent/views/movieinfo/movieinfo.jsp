<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>影片详情</title>
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
        <div class="container">
            <div class="text-center wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                <h3>${movieName }</h3>

            </div>	
            <form action="selkino.ha" method="post">
            <div class="screenshots progressive">
                <div class="row screenshot">
                    <div class="col-sm-6 no-padding left">
                        <img class="screenshot-image" src=<%=(String) request.getAttribute("pic") %>></div>
                    <div class="col-lg-4 col-sm-offset-1 col-sm-5">
                        <div class="screenshot-info wow fadeInUp" data-index="1" style="visibility: visible; animation-name: fadeInUp;">
                            <h5>${movieRank }</h5>
                            <p>
                                ${movieDescription }
                            </p>
                        </div>
                        <input name="filmid" type="text" style="display:none" value=${filmID }></input>
                        <button type="submit" class="button full col-md-offset-4">立即订票</button>
                    </div>
                </div>
            </div>
            </form>
        </div>
    </section>
    

</body>