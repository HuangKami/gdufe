package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.EnglishGrade;
import kami.gdufe.model.Grade;
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

	/**
	 * 获取成绩
	 * 
	 * @param request
	 * @param model
	 * @param stu_time
	 * @return
	 */
	@RequestMapping("/gradeInfo")
	public String getGrades(HttpServletRequest request, Model model, String stu_time) {
		List<Grade> grades = gradeServie.getGrades(getSessionUser(request), stu_time);
		if (grades != null && grades.size() > 0) {
			model.addAttribute("grades", grades);
			model.addAttribute("gpa", gradeServie.getGPA(grades));
		} else {
			model.addAttribute("noGrades", "卧槽，查询不到成绩啊");
		}
		return "gradesInfo";
	}

	/**
	 * 获取四六级成绩
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/englishGradeInfo")
	public String getGrades(HttpServletRequest request, Model model, String zkzh, String xm) {
		EnglishGrade englishGrade = gradeServie.getEnglishGrades(getSessionUser(request), zkzh, xm);
		if (englishGrade != null) {
			model.addAttribute("englishGrade", englishGrade);
		} else {
			model.addAttribute("noEnglishGrades", "卧槽，查询不到四六级成绩啊");
		}
		return "englishGradeInfo";
	}
}
