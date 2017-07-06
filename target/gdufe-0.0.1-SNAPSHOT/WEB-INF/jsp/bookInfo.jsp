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
	var noBookInfo = "${noBookInfo}";
	if (noBookInfo != "") {
		alert(noBookInfo);
	}
</script>
</head>

<body>
	<div class="title">书籍信息</div>
	<table id="Main">
		<tr class="tbTitle">
			<th>书名</th>
			<th>序列号</th>
			<th>库藏总数量</th>
			<th>可借数量</th>
			<th>作者</th>
			<th>出版社</th>
			<th>查看详细内容</th>
		</tr>
		<c:forEach var="bookInfo" items="${bookInfos}">
			<tr class="tbContext">
				<td>${bookInfo.name}</td>
				<td>${bookInfo.serial}</td>
				<td>${bookInfo.numAll}</td>
				<td>${bookInfo.numCan}</td>
				<td>${bookInfo.author}</td>
				<td>${bookInfo.publisher}</td>
				<td><a href="bookLocation?macno=${bookInfo.macno}">查看</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
