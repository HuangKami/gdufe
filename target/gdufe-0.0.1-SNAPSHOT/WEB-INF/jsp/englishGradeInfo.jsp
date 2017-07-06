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
	var noEnglishGrades = "${noEnglishGrades}";
	if (noEnglishGrades != "") {
		alert(noEnglishGrades);
	}
</script>
</head>

<body>
	<div class="title">四六级成绩</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>姓名</th>
			<th>学校</th>
			<th>英语四级/英语六级</th>
			<th>准考证号</th>
			<th>总分数</th>
			<th>听力分数</th>
			<th>阅读分数</th>
			<th>写作分数</th>
		</tr>
		<tr class="tbContext">
			<td>${englishGrade.time}</td>
			<td>${englishGrade.school}</td>
			<td>${englishGrade.level}</td>
			<td>${englishGrade.cetId}</td>
			<td>${englishGrade.score}</td>
			<td>${englishGrade.listenScore}</td>
			<td>${englishGrade.readScore}</td>
			<td>${englishGrade.writeScore}</td>
		</tr>
	</table>
</body>
</html>
