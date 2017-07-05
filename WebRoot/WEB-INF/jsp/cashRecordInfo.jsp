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
	var noCashRecord = "${noCashRecord}";
	if (noCashRecord != "") {
		alert(noCashRecord);
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
		<tr>
			<th>交易时间</th>
			<th>交易商户</th>
			<th>交易额</th>
			<th>余额</th>
		</tr>
		<c:forEach var="cashRecord" items="${cashRecords}">
			<tr>
				<td>${cashRecord.time}</td>
				<td>${cashRecord.shop}</td>
				<td>${cashRecord.change}</td>
				<td>${cashRecord.cash}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
