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
<script type="text/javascript">
	var noCourses = "${noCourses}";
	if (noCourses != "") {
		alert(noCourses);
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
		<tr>
			<th>课程名</th>
			<th>上课老师</th>
			<th>上课周数</th>
			<th>上课教室</th>
			<th>周几</th>
			<th>开始小节</th>
			<th>结束小节</th>
		</tr>
		<c:forEach var="course" items="${courses}">
		<tr>
			<td>${course.name}</td>
			<td>${course.teacher}</td>
			<td>${course.period}</td>
			<td>${course.location}</td>
			<td>${course.dayInWeek}</td>
			<td>${course.startSec}</td>
			<td>${course.endSec}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
