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
	var noGrades = "${noGrades}";
	if (noGrades != "") {
		alert(noGrades);
	}
</script>
</head>

<body>
	<div class="title">成绩</div>
	<table id="Main">
		<h2>平均绩点：${gpa}</h2>
		<tr class="tbTitle">
			<th>开课学期</th>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>平时成绩</th>
			<th>实验成绩</th>
			<th>期末成绩</th>
			<th>成绩</th>
			<th>学分</th>
		</tr>
		<c:forEach var="grade" items="${grades}">
			<tr class="tbContext">
				<td>${grade.time}</td>
				<td>${grade.classCode}</td>
				<td>${grade.name}</td>
				<td>${grade.dailyScore}</td>
				<td>${grade.expScore}</td>
				<td>${grade.paperScore}</td>
				<td>${grade.score}</td>
				<td>${grade.credit}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
