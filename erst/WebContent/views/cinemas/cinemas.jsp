<%@ page language="java" import="java.util.*,com.sbw.erst.model.*,com.sbw.erst.controller.ErsteController" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="notranslate scheme-lighter_gray_backdrop ml no-ms no-mm size-large responsive js no-touch csstransforms csstransitions smil no-overflowscrolling filereader no-force-desktop wf-aktivgroteskstd-n2-active wf-aktivgroteskstd-n3-active wf-alternategothicno3d-n4-active wf-dincondensedweb-n4-active wf-active" xmlns:fb="http://ogp.me/ns/fb#">
<head>
  <title>选择场次</title>
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
    ArrayList<Integer> sl = (ArrayList<Integer>)request.getAttribute("sessions");
  %>
  <div class="search-result">
    <div class=" dss98 startups-show fhr17 header _a _jm search-result-list">
      <p class="search-num-info">共有
        <span id="search-num"><%=sl.size() %></span>场：</p>

    </div>
    <h1>-------------------------------------------------------------------</h1>
    <div>
      <%
      	for (int i = 0; i < sl.size(); i++) {
      		Session s = new Session(sl.get(i).intValue());
      		int roomid = s.getRoomId();
      		Cinema c = new Cinema(roomid/100);
      		String cname = c.getCinemaName();
      		String loc = c.getLocation();
      		double price = s.getPrice();
      		String bZeit = s.getBeginTime();
      		String eZeit = s.getEndTime();
      		String picdir = "images/c"+c.getCinemaId()+".jpg";
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
                        				<h1><%=cname+" -- "+DBOperation.getInstance().getRoomName(roomid) %></h1><br/>
                        				<h2><%=loc %></h2>
                        				<h2><%=bZeit+" ~ "+eZeit %></h2>
                    				</div>
                    				<h2 class="high_concept">
                        				<p>￥<%=price %></p>
                    				</h2>
                				</div>
            				</div>
            				<form action="selseat.ha" method="post">
            					<input type="text" style="display:none" name="sessionid" value=<%=s.getSessionId() %> />
                    			<button type="submit" class="button full col-md-offset-4">订票</button>
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