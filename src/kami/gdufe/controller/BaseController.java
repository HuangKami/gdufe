package kami.gdufe.controller;

import javax.servlet.http.HttpServletRequest;

import kami.gdufe.model.User;

public class BaseController {
	/**
	 * 获取session中的User
	 * 
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User)request.getSession().getAttribute("user");
	}
	
	/**
	 * 把User存进session中
	 */
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute("user", user);
	}
}
