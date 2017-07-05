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
	var noBookLocation = "${noBookLocation}";
	if (noBookLocation != "") {
		alert(noBookLocation);
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
		<tr>
			<th>条码号</th>
			<th>序列号</th>
			<th>年卷期</th>
			<th>馆藏地</th>
			<th>可借状态</th>
		</tr>
		<c:forEach var="bookLocation" items="${bookLocations}">
			<tr>
			<td>${bookLocation.barId}</td>
			<td>${bookLocation.serial}</td>
			<td>${bookLocation.volume}</td>
			<td>${bookLocation.location}</td>
			<td>${bookLocation.state}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
