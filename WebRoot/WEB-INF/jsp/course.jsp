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
			url : '<%=basePath%>courcesInfo',  
			data : {
				"stu_time" : stu_time,
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#Main").append("<tr class='tbTitle'><th>课程名</th><th>上课老师</th><th>上课周数</th><th>上课教室</th><th>周几</th><th>开始小节</th><th>结束小节</th></tr>");
				var json = eval(data);
				$.each(json, function(index, item) {
					$("#Main").append("<tr id='" + index + "' class='tbContext'> ");
					$("#"+ index).append("<td>" + json[index].name + "</td>");
					$("#"+ index).append("<td>" + json[index].teacher + "</td>");
					$("#"+ index).append("<td>" + json[index].period + "</td>");
					$("#"+ index).append("<td>" + json[index].location + "</td>");
					$("#"+ index).append("<td>" + json[index].dayInWeek + "</td>");
					$("#"+ index).append("<td>" + json[index].startSec + "</td>");
					$("#"+ index).append("<td>" + json[index].endSec + "</td>");
					$("#Main").append("</tr>");
				});
			}
		});
	}
	
</script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="title">课程表</div>
	<div class="d2">
		<div class="div">
			 <select id="stu_time" name="stu_time" style="width: 150px">
				<option>2014-2015-1</option>
				<option>2014-2015-2</option>
				<option>2015-2016-1</option>
				<option>2015-2016-2</option>
				<option>2016-2017-1</option>
				<option>2016-2017-2</option>
			</select>
			<button type="button" onclick="search();"></button>
		</div>
	</div>
	<table id="Main">
	</table>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
