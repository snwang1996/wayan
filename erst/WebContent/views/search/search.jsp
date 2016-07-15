<%@ page language="java" import="java.util.*,com.sbw.erst.model.*,com.sbw.erst.controller.ErsteController" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="notranslate scheme-lighter_gray_backdrop ml no-ms no-mm size-large responsive js no-touch csstransforms csstransitions smil no-overflowscrolling filereader no-force-desktop wf-aktivgroteskstd-n2-active wf-aktivgroteskstd-n3-active wf-alternategothicno3d-n4-active wf-dincondensedweb-n4-active wf-active" xmlns:fb="http://ogp.me/ns/fb#">
<head>
  <title>搜索结果</title>
  <meta charset="utf-8"/>

  <link href="/erst/views/search/search.css" rel="stylesheet" type="text/css">
  <link href="/erst/views/common.css" rel="stylesheet" type="text/css">

<body class=" dl85 layouts fbe11 base _a _jm home affix">
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
  <% 
    ArrayList<Film> fl = (ArrayList<Film>)request.getAttribute("filmList");
  %>
  <div class="search-result">
    <div class=" dss98 startups-show fhr17 header _a _jm search-result-list">
      <p class="search-num-info">搜索到
        <span id="search-num"><%=fl.size() %></span>条结果</p>

    </div>
    <h1>-------------------------------------------------------------------</h1>
    <div>
      <%
      	for (int i = 0; i < fl.size(); i++) {
      		Film f = fl.get(i);
      		String name = f.getFilmName();
      		String desc = f.getDescription();
      		double rank = f.getRank();
      		String picdir = "images/"+f.getFilmID()+".jpg";
      		%>
      			<div class="summary">
    				<div class="controls"></div>
    				<div class="editable_region">
        				<div class="show">
            				<div class="main standard g-lockup larger">
                				<div class="photo">
                    				<img alt="movie" src=<%=picdir %>></div>
                				<div class="text">
                    				<div class="name_holder">
                        				<h1 class="name"><%=name %></h1>
                    				</div>
                    				<h2 class="high_concept">
                        				<p>评分: <%=rank %></p>
                    				</h2>
                				</div>
            				</div>
            				<form action="info.ha" method="post">
            					<input type="text" style="display:none" name="filmid" value=<%=f.getFilmID() %> />
                    			<button type="submit" class="button full col-md-offset-4">查看详情</button>
            				</form>
        				</div>
    				</div>
				</div>
				<h1>-------------------------------------------------------------------</h1>
      		<%
      	}
      %>
  	</div>
  </div>
  <script src="/erst/views/jquery.js"></script>

  <!-- script src="/erst/views/search/search.js"/ -->
</body>
</html>