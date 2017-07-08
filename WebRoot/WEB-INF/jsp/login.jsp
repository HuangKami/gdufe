<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>广财突突突登录界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/jquery.js"></script>
</head>

<body class="body1">
	<div id="login" class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="../images/avtar.png" />
		</div>
		<form action="<%=basePath%>index" method="post">
			<input type="text" id="sno" name="sno" class="text" placeholder="请输入学号">
			<div class="key">
				<input type="password" id="pwd" name="pwd" placeholder="请输入密码">
			</div>
			<div id="signin" class="signin">
				<input type="submit" value="登录">
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var error = "${error}";
	if(error != "") {
		alert(error);
	}
</script>
<script type="text/javascript">
	var system ={}; 
    var p = navigator.platform;      
    system.win = p.indexOf("Win") == 0; 
    system.mac = p.indexOf("Mac") == 0; 
    system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);    
    if(!(system.win||system.mac||system.xll)){//如果是手机
         $("body").attr("class", "body2");
      	 $("#login").css("margin-top", "300px");
      	 $("#login").css("width", "50%");
    }
</script>
</html>
