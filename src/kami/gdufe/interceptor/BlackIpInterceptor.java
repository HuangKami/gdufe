package kami.gdufe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kami.gdufe.dao.BlackListDao;
import kami.gdufe.dao.impl.BlackListDaoImpl;
import kami.gdufe.utils.GetApplicationContext;

public class BlackIpInterceptor implements HandlerInterceptor {
	private Integer times = 30;

	/**
	 * 过滤拦截黑名单IP
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ApplicationContext applicationContext = GetApplicationContext.getApplicationContext();
		BlackListDao blackListDao = applicationContext.getBean("blackListDaoImpl", BlackListDaoImpl.class);

		String ip = getRemortIP(request);
		/**
		 * 判断用户是否在黑名单中
		 */
		if (blackListDao.isInBlackList(ip)) {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			return false;
		}

		/**
		 * 判断用户在限定时间内是否频繁访问
		 */
		if (blackListDao.findIp(ip) > times) {
			blackListDao.insertBlackList(ip);
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			return false;
		}

		/**
		 * 验证通过
		 */
		blackListDao.InsertIp(ip);
		return true;
	}

	private String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null){
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
