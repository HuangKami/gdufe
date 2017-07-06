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
<script type="text/javascript">
	var noHisData = "${noHisData}";
	if (noHisData != "") {
		alert(noHisData);
	}
</script>
</head>

<body>
	<div class="title">历史借阅</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>条码号</th>
			<th>书名</th>
			<th>作者</th>
			<th>借阅时间</th>
			<th>已归还时间</th>
			<th>馆藏地</th>
		</tr>
		<c:forEach var="bookBollowed" items="${bookBolloweds}">
			<tr class="tbContext">
				<td>${bookBollowed.barId}</td>
				<td>${bookBollowed.name}</td>
				<td>${bookBollowed.author}</td>
				<td>${bookBollowed.borrowedTime}</td>
				<td>${bookBollowed.returnTime}</td>
				<td>${bookBollowed.location}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
