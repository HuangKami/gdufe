<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>

<body class="body1">
	<div class="title">用户信息</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>姓名</th>
			<th>姓名拼音</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>民族</th>
			<th>政治面貌</th>
			<th>学历</th>
			<th>学院</th>
			<th>专业</th>
			<th>班级</th>
		</tr>
		<tr class="tbContext">
			<td>${user.name}</td>
			<td>${user.namePy}</td>
			<td>${user.sex}</td>
			<td>${user.birthday}</td>
			<td>${user.nation}</td>
			<td>${user.party}</td>
			<td>${user.education}</td>
			<td>${user.department}</td>
			<td>${user.major}</td>
			<td>${user.classroom}</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="js/common.js"></script>
</html>
