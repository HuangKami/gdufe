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
	<div class="title">校园卡交易记录</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>交易时间</th>
			<th>交易商户</th>
			<th>交易额</th>
			<th>余额</th>
		</tr>
		<c:forEach var="cashRecord" items="${cashRecords}">
			<tr class="tbContext">
				<td>${cashRecord.time}</td>
				<td>${cashRecord.shop}</td>
				<td>${cashRecord.change}</td>
				<td>${cashRecord.cash}</td>
			</tr>
		</c:forEach>
	</table>
<script type="text/javascript">
	var noCashRecord = "${noCashRecord}";
	if (noCashRecord != "") {
		alert(noCashRecord);
	}
</script>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
