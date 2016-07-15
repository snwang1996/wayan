<%@ page language="java" import="java.util.*,com.sbw.erst.model.*,com.sbw.erst.controller.ErsteController" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/erst/views/common.css">
    <link rel="stylesheet" href="/erst/views/main/main.css">
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
                        <a href="." class="button smooth scroll hidden-xs">注销</a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <section id="pricing" class="pricing background overlay">
        <div class="container">
            <div class="text-center wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                <h1 class="main-title">蛙眼</h1>
                <h4>互联网电影清真售票系统</h4>
            </div>
            <form action="search.ha" method="post" id="search-form">
            	<div class="searchInput input-group col-md-8 col-md-offset-2 form-group">
                	<input type="text" class="form-control" name="movieName" required="required" placeholder="影片名称" aria-describedby="basic-addon2" id="search"><span><input type="submit" class="button full" placeholder="搜索" id="submit-button"/></span>  
                </div>
            </form>
            <%
            	Integer film1id = (Integer)request.getAttribute("film1");
            	Integer film2id = (Integer)request.getAttribute("film2");
            	Integer film3id = (Integer)request.getAttribute("film3");
            	Film film1 = new Film(film1id);
            	Film film2 = new Film(film2id);
            	Film film3 = new Film(film3id);
            %>
            <div class="row wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                <div class="col-md-4">
                    <form class="plan text-center" action="info.ha" method="post" id="trial">
                        <ul><%=film1.getFilmName() %></ul>
                        <img src=<%="images/"+film1id+".jpg" %> alt="Trial plan" width="150" height="176">
                        <ul>
                            <li><%="评分："+film1.getRank() %></li>
                        </ul>
                        <input type="text" name="filmid" style="display:none" value=<%=film1id %> ></input>
                        <button type="submit" class="button full col-md-offset-4">订票</button>
                    </form>
                </div>
                <div class="col-md-4">
                    <form class="plan text-center" action="info.ha" method="post" id="trial">
                        <ul><%=film2.getFilmName() %></ul>
                        <img src=<%="images/"+film2id+".jpg" %> alt="Trial plan" width="150" height="176">
                        <ul>
                            <li><%="评分："+film2.getRank() %></li>
                        </ul>
                        <input type="text" name="filmid" style="display:none" value=<%=film2id %> ></input>
                        <button type="submit" class="button full col-md-offset-4">订票</button>
                    </form>
                </div>
                <div class="col-md-4">
                    <form class="plan text-center" action="info.ha" method="post" id="trial">
                        <ul><%=film3.getFilmName() %></ul>
                        <img src=<%="images/"+film3id+".jpg" %> alt="Trial plan" width="150" height="176">
                        <ul>
                            <li><%="评分："+film3.getRank() %></li>
                        </ul>
                        <input type="text" name="filmid" style="display:none" value=<%=film3id %> ></input>
                        <button type="submit" class="button full col-md-offset-4">订票</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

</body>