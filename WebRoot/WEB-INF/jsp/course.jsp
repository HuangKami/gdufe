<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>广财突突突</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/table.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/table.css" rel='stylesheet' type='text/css' />
</head>

<body>
	<div>
	  <form action="courcesInfo" method="post">
		  <select name="stu_time">
				<option>2014-2015-1</option>
				<option>2014-2015-2</option>
				<option>2015-2016-1</option>
				<option>2015-2016-2</option>
				<option>2016-2017-1</option>
				<option>2016-2017-2</option>
			</select>
		  <button type="submit">查询</button>
	  </form>
	</div>
	<div></div>
</body>
</html>
