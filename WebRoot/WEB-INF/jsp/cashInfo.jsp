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
	var noCash = "${noCash}";
	if (noCash != "") {
		alert(noCash);
	}
</script>
</head>

<body>
	<table border="1px">
		<tr>
		<tr>
			<th>校园卡卡号</th>
			<th>当前余额</th>
			<th>卡状态</th>
			<th>检查状态</th>
			<th>挂失状态</th>
			<th>冻结状态</th> </tr>
		<tr>
			<td>${cash.cardNum}</td>
			<td>${cash.cash}</td>
			<td>${cash.cardState}</td>
			<td>${cash.checkState}</td>
			<td>${cash.lossState}</td>
			<td>${cash.freezeState}</td>
		</tr>
	</table>
</body>
</html>
