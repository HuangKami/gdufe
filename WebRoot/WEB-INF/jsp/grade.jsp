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
	function search(page) {
		var stu_time = $("#stu_time").val();
		$("#Main").html("");
		$.ajax({
			url : '<%=basePath%>gradeInfo',
			data : {
				"stu_time" : stu_time,
				"pageNow" : page,
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#Main").append("<tr class='tbTitle'><th>开课学期</th><th>课程编号</th><th>课程名称</th><th>平时成绩</th><th>实验成绩</th><th>期末成绩</th><th>成绩</th><th>学分</th></tr>");
				var json = eval(data);
				$.each(json, function(index, item) {
					$("#Main").append("<tr id='" + index + "' class='tbContext'> ");
					$("#" + index).append("<td>" + json[index].time + "</td>");
					$("#" + index).append("<td>" + json[index].classCode + "</td>");
					$("#" + index).append("<td>" + json[index].name + "</td>");
					$("#" + index).append("<td>" + json[index].dailyScore + "</td>");
					$("#" + index).append("<td>" + json[index].expScore + "</td>");
					$("#" + index).append("<td>" + json[index].paperScore + "</td>");
					$("#" + index).append("<td>" + json[index].score + "</td>");
					$("#" + index).append("<td>" + json[index].credit + "</td>");
					$("#Main").append("</tr>");
				});
				getGpa();
				getPage(page);
			}
		});
	}

	function getGpa() {
		var stu_time = $("#stu_time").val();
		$.ajax({
			url : '<%=basePath%>getGpa',
			type : 'post',
			data : {
				"stu_time" : stu_time,
			},
			dataType : 'json',
			success : function(data) {
				$("#gpa").text("平均绩点：" + data);
			}
		});
	}

	function getPage(page) {
		var stu_time = $("#stu_time").val();
		$.ajax({
			url : '<%=basePath%>getGradePage',
			type : 'post',
			data : {
				"stu_time" : stu_time,
				"pageNow" : page,
			},
			dataType : 'json',
			success : function(data) {
				$("#page").html("");
				var json = eval(data);
				if(json.totalPage > 1) {
					for (var i = 1; i <= json.totalPage; i++) {
						$("#page").append("<button class='subbtn' type='button' onclick=search(" + i + "," + stu_time + ");>" + i + "</button>")
					}
				}

			}
		});
	}
</script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="title">期末成绩</div>
	<div class="d2">
		<div class="div">
			<select id="stu_time" name="stu_time" style="width: 150px">
				<option>2014-2015-1</option>
				<option>2014-2015-2</option>
				<option>2015-2016-1</option>
				<option>2015-2016-2</option>
				<option>2016-2017-1</option>
				<option>2016-2017-2</option>
				<option>整个大学</option>
			</select>
			<button type="button" onclick="search(1);"></button>
		</div>
	</div>
	<h3 id="gpa" style="text-align: center;color: rgba(150,255,255,0.95);"></h3>
	<table id="Main">
	</table>
	<center>
		<div id="page" style="margin-top: 10px"></div>
	</center>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
