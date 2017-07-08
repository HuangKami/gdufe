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

<title>广财突突突</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../css/table.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/jquery.js"></script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="title">当前借阅</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>书名</th>
			<th>作者</th>
			<th>借阅时间</th>
			<th>已归还时间</th>
			<th>已续借次数</th>
			<th>馆藏地</th>
		</tr>
		<c:forEach var="bookBollowed" items="${bookBolloweds}">
			<tr class="tbContext">
				<td>${bookBollowed.name}</td>
				<td>${bookBollowed.author}</td>
				<td>${bookBollowed.borrowedTime}</td>
				<td>${bookBollowed.returnTime}</td>
				<td>${bookBollowed.renewTimes}</td>
				<td>${bookBollowed.location}</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<div id="page" style="margin-top: 10px"></div>
	</center>
<script type="text/javascript">
	var noNowData = "${noNowData}";
	if (noNowData != "") {
		alert(noNowData);
	}
	
	if(${pageBean.totalPage} > 1) {
		for (var i = 1; i <= ${pageBean.totalPage}; i++) {
			$("#page").append("<a href='<%=basePath%>nowBollowed?pageNow=" + i +"'><button class='subbtn' type='button'>" + i + "</button></a>");
		}
	}
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
