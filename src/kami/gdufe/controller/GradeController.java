package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kami.gdufe.model.EnglishGrade;
import kami.gdufe.model.Grade;
import kami.gdufe.model.PageBean;
import kami.gdufe.service.GradeService;

@Controller
public class GradeController extends BaseController {
	@Resource
	private GradeService gradeServie;
	
	/**
	 * 成绩首页
	 */
	@RequestMapping("/grade")
	public String index() {
		return "grade";
	}
	
	@RequestMapping("english")
	public String englishIndex() {
		return "english";
	}

	/**
	 * 获取成绩
	 * 
	 * @param request
	 * @param model
	 * @param stu_time
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/gradeInfo")
	public List<Grade> getGrades(HttpServletRequest request, String stu_time, Integer pageNow) {
		return gradeServie.getGrades(getSessionUser(request), stu_time, pageNow);
	}
	
	/**
	 * 获取GPA
	 */
	@ResponseBody
	@RequestMapping("/getGpa")
	public String getGPA(HttpServletRequest request, String stu_time) {
		return gradeServie.getGPA(gradeServie.getGrades(getSessionUser(request), stu_time));
	}
	
	/**
	 * 获取分页信息
	 */
	@ResponseBody
	@RequestMapping("/getGradePage")
	public PageBean getPageBean(HttpServletRequest request, String stu_time, Integer pageNow) {
		return gradeServie.getPageBean(getSessionUser(request), stu_time, pageNow);
	}

	/**
	 * 获取四六级成绩
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/englishGradeInfo")
	public EnglishGrade getGrades(HttpServletRequest request, String zkzh, String xm) {
		return gradeServie.getEnglishGrades(getSessionUser(request), zkzh, xm);
	}
}
