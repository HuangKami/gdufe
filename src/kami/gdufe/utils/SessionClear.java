package kami.gdufe.utils;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.context.ApplicationContext;

import kami.gdufe.model.User;
import kami.gdufe.service.CashService;
import kami.gdufe.service.CourceService;
import kami.gdufe.service.GradeService;
import kami.gdufe.service.LibraryService;
import kami.gdufe.service.SutuoService;
import kami.gdufe.service.impl.CashServiceImpl;
import kami.gdufe.service.impl.CourceServiceImpl;
import kami.gdufe.service.impl.GradeServiceImpl;
import kami.gdufe.service.impl.LibraryServiceImpl;
import kami.gdufe.service.impl.SutuoServiceImpl;

public class SessionClear implements HttpSessionAttributeListener {
	private CashService cashService;
	private CourceService courceService;
	private GradeService gradeService;
	private LibraryService libraryService;
	private SutuoService sutuoService;

	/**
	 * 试过很多次session销毁时触发清除，可是关闭浏览器，session过期都不行，只能在session开启add User时清除以前的缓存
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 获得容器对象
		ApplicationContext applicationContext = GetApplicationContext.getApplicationContext();
		cashService = applicationContext.getBean("cashServiceImpl", CashServiceImpl.class);
		courceService = applicationContext.getBean("courceServiceImpl", CourceServiceImpl.class);
		sutuoService = applicationContext.getBean("sutuoServiceImpl", SutuoServiceImpl.class);
		gradeService = applicationContext.getBean("gradeServiceImpl", GradeServiceImpl.class);
		libraryService = applicationContext.getBean("libraryServiceImpl", LibraryServiceImpl.class);

		// 清除
		User user = (User) event.getSession().getAttribute("user");
		cashService.clear(user);
		courceService.clear(user);
		sutuoService.clear(user);
		gradeService.clear(user);
		libraryService.clear(user);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}
}
