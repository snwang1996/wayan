<%@ page language="java" import="java.util.*,com.sbw.erst.model.*,com.sbw.erst.controller.ErsteController" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>选座</title>
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
	<br/><br/><br/><br/><br/>
	<h1 align="center">请选择座位</h1>
	<h2 align="center">----------------------------------屏幕----------------------------------</h2>
    <div align="center">
        <%
        	int sessionid = (int) request.getAttribute("sessionid");
          	Session s = new Session(sessionid);
          	int roomSize = DBOperation.getInstance().getRoomSize(s.getRoomId());
        	for (int i = 0; i < roomSize/100; i++) {
        		for (int j = 0; j < roomSize%100; j++) {
        			int seatid = s.getRoomId()*10000+i*100+j;
        			if (DBOperation.getInstance().isReservationValid(sessionid, seatid)) {
        			%>
        				<form action="reservation.ha" style="margin:0px;display:inline" method="post">
        				 	<input type="text" name="sessionid" value=<%=sessionid %> style="display:none"></input>
        					<button type="submit" style="color:blue" name="seatid" value=<%=seatid %> >订票</button>
        				</form>
        			<%
        			} else {
        			%>
        				<form action="reservation.ha" style="margin:0px;display:inline" method="post">
        					<input type="text" name="sessionid" value=<%=sessionid %> style="display:none"></input>
        					<button type="submit" style="color:red" name="seatid" disabled="disabled" value=<%=seatid %> >已订</button>
        				</form>
        			<%
        			}
        		}
        		%>
        		<br/><br/><br/>
        	<%
        	}
        %>
    </div>
    

</body>