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
	var noGrades = "${noGrades}";
	if (noGrades != "") {
		alert(noGrades);
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
		<tr>
			<th>素拓模块名</th>
			<th>所需最少学分</th>
			<th>已修学分</th>
		</tr>
		<c:forEach var="sutuo" items="${sutuos}">
		<tr>
			<td>${sutuo.name}</td>
			<td>${sutuo.requireScore}</td>
			<td>${sutuo.score}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
