<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="db.ha" method="post">
	<input type="text" name="command" value=""/><br/>
	<input type="text" name="param1" value=""/><br/>
	<textarea style="width:200px;height:80px;" name="param2"></textarea><br/>
	<input type="text" name="param3" value=""/><br/>
	<input type="text" name="param4" value=""/><br/>
	<input type="text" name="param5" value=""/><br/>
	<input type="submit" value="确定"/><br/>
	<h2>${hint }</h2>
</form>
</body>
</html>