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
 	<div class="title">校园卡余额</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>校园卡卡号</th>
			<th>当前余额</th>
			<th>卡状态</th>
			<th>检查状态</th>
			<th>挂失状态</th>
			<th>冻结状态</th> 
			<th>查看当天交易记录</th> 
		</tr>
		<tr class="tbContext">
			<td>${cash.cardNum}</td>
			<td>${cash.cash}</td>
			<td>${cash.cardState}</td>
			<td>${cash.checkState}</td>
			<td>${cash.lossState}</td>
			<td>${cash.freezeState}</td>
			<td><a href="<%=basePath%>cashRecordInfo">查看</a></td>
		</tr>
	</table>
<script type="text/javascript">
	var noCash = "${noCash}";
	if (noCash != "") {
		alert(noCash);
	}
</script>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
