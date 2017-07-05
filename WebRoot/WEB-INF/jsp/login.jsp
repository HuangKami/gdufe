<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>广财突突突登录界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript">
	var error = "${error}";
	if(error != "") {
		alert(error);
	}
</script>
</head>

<body>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<form action="index" method="post">
			<input type="text" id="sno" name="sno" class="text" value="请输入学号"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '请输入学号';}">
			<div class="key">
				<input type="password" id="pwd" name="pwd" value="请输入密码" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '请输入密码';}">
			</div>
			<div class="signin">
				<input type="submit" value="登录">
			</div>
		</form>
	</div>
</body>
</html>
