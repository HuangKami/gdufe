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
		bookName = $("#search").val();
		if (bookName == "") {
			alert("请输入图书名称");
			return false;
		}
		
		$("#Main").html("");
		$.ajax({
			url : '<%=basePath%>bookInfo',  
			data : {
				"bookName" : bookName,
				"pageNow" : page,
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#Main").append("<tr class='tbTitle'><th>书名</th><th>序列号</th><th>库藏总数量</th><th>可借数量</th><th>作者</th><th>出版社</th><th>查看详细内容</th></tr>");
				var json = eval(data);
				$.each(json, function(index, item) {
					$("#Main").append("<tr id='" + index + "' class='tbContext'> ");
					$("#"+ index).append("<td>" + json[index].name + "</td>");
					$("#"+ index).append("<td>" + json[index].serial + "</td>");
					$("#"+ index).append("<td>" + json[index].numAll + "</td>");
					$("#"+ index).append("<td>" + json[index].numCan + "</td>");
					$("#"+ index).append("<td>" + json[index].author + "</td>");
					$("#"+ index).append("<td>" + json[index].publisher + "</td>");
					$("#"+ index).append("<td><a href='<%=basePath%>bookLocation?macno=" + json[index].macno + "'>查看</a></td>");
					$("#Main").append("</tr>");
				});
				getPage(page);
			}
		});
	}
	
	function getPage(page) {
		var bookName = $("#search").val();
		$.ajax({
			url : '<%=basePath%>getBookPage',
			type : 'post',
			data : {
				"bookName" : bookName,
				"pageNow" : page,
			},
			dataType : 'json',
			success : function(data) {
				$("#page").html("");
				var json = eval(data);
				if(json.totalPage > 1) {
					for (var i = 1; i <= json.totalPage; i++) {
						$("#page").append("<button class='subbtn' type='button' onclick=search(" + i + ");>" + i + "</button>")
					}
				}

			}
		});
	}
</script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="title">搜索图书</div>
	<div class="d1">
		<div class="div">
			<input id="search" type="text" placeholder="点击搜索图书">
			<button type="button" onclick="search(1);"></button>
		</div>
	</div>
	<table id="Main"></table>
	<center>
		<div id="page" style="margin-top: 10px"></div>
	</center>
</body>
<script type="text/javascript" src="../js/common.js"></script>
</html>
