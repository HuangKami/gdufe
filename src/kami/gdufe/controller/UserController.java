package kami.gdufe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.User;
import kami.gdufe.service.UserService;

@Controller
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/userInfo")
	public String getUserInfo(HttpServletRequest request, Model model) {
		User user = getSessionUser(request);
		if(user == null) {
			return "login";
		}
		model.addAttribute("user", user);
		return "userInfo";
	}
}
