package kami.gdufe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.User;
import kami.gdufe.service.UserService;
/**
 * 登录
 * @author Kami
 * @time 2017年7月1日
 */
@Controller
public class LoginController extends BaseController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String doLogin(User user, Model model,
			HttpServletRequest request) {
		//判断session是否有user
		if(getSessionUser(request) != null) {
			model.addAttribute("user", getSessionUser(request));
			return "index";
		}
		//没有就查询，判断用户的账号密码是否正确
		User loginUser = userService.getUser(user);
		if(loginUser != null) {
			setSessionUser(request, loginUser);
			model.addAttribute("user", loginUser);
			return "index";
		}
		model.addAttribute("error", "账号或密码不正确");
		return "login";
	}
}
