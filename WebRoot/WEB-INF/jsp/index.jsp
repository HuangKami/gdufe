<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="../css/index.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/jquery.js"></script>
</head>

<body class="body1">
	<div class="agile-heading heading">
		<h3 style="color:#fc636b">广财突突突</h3>
	</div>
	<div class="services" id="services">
		<div class="container">
			<div class="wthree-services-grids">
				<a href="<%=basePath%>userInfo">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg1">
								<h3 id="user" style="">个人信息</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>个人信息</h4>
								<p>点击查询个人详细信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>cashInfo">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg2">
								<h3 id="cash" style="">校园卡</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>校园卡</h4>
								<p>点击查询饭卡余额状态以及当天的交易记录，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>grade">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg3">
								<h3 id="grade" style="">成绩查询</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>成绩查询</h4>
								<p>点击查询期末成绩，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>english">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg7">
								<h3 id="english" style="">四六级查询</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>四六级查询</h4>
								<p>点击查询四六级成绩，突突突</p>
							</div>
						</div>
					</div>
				</a>
				<div class="clearfix"></div>
			</div>

			<div class="wthree-services-grids services-grids1">
				<a href="<%=basePath%>library">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg4">
								<h3 id="library" style="">图书馆服务</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>图书馆服务</h4>
								<p>点击查询图书借阅历史记录，当前记录，续借，搜索图书信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>sutuosInfo">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg5">
								<h3 id="sutuo" style="">素拓信息</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>素拓信息</h4>
								<p>点击查询素拓信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>course">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg6">
								<h3 id="n1" style="">课程表</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>课程表</h4>
								<p>点击查询课程表信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="#" onclick="return false;">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg7">
								<h3 id="n2" style="">敬请期待</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>敬请期待</h4>
								<p>敬请期待</p>
							</div>
						</div>
					</div>
				</a>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var system = {};
	var p = navigator.platform;
	system.win = p.indexOf("Win") == 0;
	system.mac = p.indexOf("Mac") == 0;
	system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
	if (!(system.win || system.mac || system.xll)) { //如果是手机
		$("body").attr("class", "body2");
		$("#user").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#cash").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#grade").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#english").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#library").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#sutuo").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#n1").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#n2").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
	}
</script>
</html>
