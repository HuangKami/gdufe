package kami.gdufe.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * 存放业务逻辑的URL和公用的资源
 * @author Kami
 * @time 2017年7月2日
 */
@Service
public class BaseServiceImpl {
	/**
	 * 获取用户信息接口URL
	 */
	@Value("${userInfoUrl}")
	protected String userInfoUrl;
	/**
	 * 获取用户成绩接口URL
	 */
	@Value("${gradeUrl}")
	protected String gradeUrl;
	/**
	 * 获取用户课程接口URL
	 */
	@Value("${courseUrl}")
	protected String courseUrl;
	/**
	 * 获取用户四六级成绩接口URL
	 */
	@Value("${englishUrl}")
	protected String englishUrl;
	/**
	 * 获取用户素拓接口URL
	 */
	@Value("${sutuoUrl}")
	protected String sutuoUrl;
	/**
	 * 获取用户余额接口URL
	 */
	@Value("${cashUrl}")
	protected String cashUrl;
	/**
	 * 获取用户交易记录接口URL
	 */
	@Value("${cashRecordUrl}")
	protected String cashRecordUrl;
	/**
	 * 获取续借接口URL
	 */
	@Value("${xujieUrl}")
	protected String xujieUrl;
	/**
	 * 获取图书信息接口URL
	 */
	@Value("${bookInfoUrl}")
	protected String bookInfoUrl;
	/**
	 * 获取搜索的图书信息接口URL
	 */
	@Value("${bookSearchUrl}")
	protected String bookSearchUrl;
	/**
	 * 获取历史借阅接口URL
	 */
	@Value("${bookHisUrl}")
	protected String bookHisUrl;
	/**
	 * 获取当前借阅接口URL
	 */
	@Value("${bookNowUrl}")
	protected String bookNowUrl;
	/**
	 * 获取验证码接口URL
	 */
	@Value("${verifyUrl}")
	protected String verifyUrl;
	
	
	/**
	 * 访问接口并获取数据
	 */
	@Resource
	protected RestTemplate restTemplate;

}
