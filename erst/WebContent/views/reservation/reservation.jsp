<%@ page language="java" import="java.util.*,com.sbw.erst.model.*,com.sbw.erst.controller.ErsteController" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>确认订单信息</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/erst/views/common.css">
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
       <h3>请确认订单信息：</h3>
            <form action="payment.ha" method="post">
            	<%
            		Session s = new Session((int)request.getAttribute("sessionid"));
            		Film f = new Film(s.getFilmId());
            		int seatid = (int)request.getAttribute("seatid");
            		Cinema c = new Cinema(seatid/1000000);
            	%>
                <h1><%=f.getFilmName() %></h1>
                <h4><%=c.getCinemaName() %></h4>
                <h4><%=DBOperation.getInstance().getRoomName(seatid/10000) %> <%=seatid%10000/100+1 %> 排 <%=seatid%100+1 %> 座</h4>
                <h4><%=s.getBeginTime() %> ~ <%=s.getEndTime() %></h4>
                <h5>地址：<%=c.getLocation() %></h5>
                <h5>联系电话：<%=c.getPhoneNum() %></h5>
                <h3>￥<%=s.getPrice() %></h3>
                <button type="submit" class="button full col-md-offset-4">支付</button>
                <input name="sessionid" value=<%=s.getSessionId() %> style="display:none"/>
                <input name="seatid" value=<%=seatid %> style="display:none"/>
            </form>
    

</body>