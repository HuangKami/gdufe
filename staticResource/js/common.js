var system = {};
var p = navigator.platform;
system.win = p.indexOf("Win") == 0;
system.mac = p.indexOf("Mac") == 0;
system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
if (!(system.win || system.mac || system.xll)) { //如果是手机
	$("body").attr("class", "body2");
}