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
<script type="text/javascript">
	function search() {
		var stu_time = $("#stu_time").val();
		$("#Main").html("");
		$.ajax({
			url : '<%=basePath%>englishGradeInfo',  
			data : {
				"zkzh" : $("#zkzh").val(),
				"xm" : $("#xm").val()
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#Main").append("<tr class='tbTitle'><th>姓名</th><th>学校</th><th>英语四级/英语六级</th><th>准考证号</th><th>总分数</th><th>听力分数</th><th>阅读分数</th><th>写作分数</th></tr>");
				$("#Main").append("<tr id='" + 1 + "' class='tbContext'> ");
				$("#"+ 1).append("<td>" + data.time + "</td>");
				$("#"+ 1).append("<td>" + data.school + "</td>");
				$("#"+ 1).append("<td>" + data.level + "</td>");
				$("#"+ 1).append("<td>" + data.cetId + "</td>");
				$("#"+ 1).append("<td>" + data.score + "</td>");
				$("#"+ 1).append("<td>" + data.listenScore + "</td>");
				$("#"+ 1).append("<td>" + data.readScore + "</td>");
				$("#"+ 1).append("<td>" + data.writeScore + "</td>");
				$("#Main").append("</tr>");
			}
		});
	}
	
</script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="title">四六级成绩</div>
	<div class="d1">
		<div class="div">
			<input id="zkzh" type="text" placeholder="请输入准考证号">
			<input id="xm" type="text" placeholder="请输入姓名">
			<button type="button" onclick="search();"></button>
		</div>
	</div>
	<table id="Main">
	</table>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
