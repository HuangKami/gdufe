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
		
		/**
		 * 判断用户是否在黑名单中
		 */
		if(blackListDao.isInBlackList(request.getRemoteAddr())) {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			return false;
		}
		
		/**
		 * 判断用户在限定时间内是否频繁访问
		 */
		if(blackListDao.findIp(request.getRemoteAddr()) > times) {
			blackListDao.insertBlackList(request.getRemoteAddr());
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			return false;
		}
		
		/**
		 * 验证通过
		 */
		blackListDao.InsertIp(request.getRemoteAddr());
		return true;
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
