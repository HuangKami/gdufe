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
	<div class="title">素拓信息</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>素拓模块名</th>
			<th>所需最少学分</th>
			<th>已修学分</th>
		</tr>
		<c:forEach var="sutuo" items="${sutuos}">
		<tr class="tbContext">
			<td>${sutuo.name}</td>
			<td>${sutuo.requireScore}</td>
			<td>${sutuo.score}</td>
		</tr>
		</c:forEach>
	</table>
<script type="text/javascript">
	var noGrades = "${noGrades}";
	if (noGrades != "") {
		alert(noGrades);
	}
</script>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
