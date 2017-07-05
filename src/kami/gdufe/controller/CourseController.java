package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.Course;
import kami.gdufe.service.CourceService;

@Controller
public class CourseController extends BaseController {
	@Resource
	private CourceService courceService;
	
	@RequestMapping("/courcesInfo")
	public String getCources(HttpServletRequest request, 
			Model model, String stu_time) {
		List<Course> courses = courceService.getCourses(getSessionUser(request), stu_time);
		if(courses != null && courses.size() > 0) {
			model.addAttribute("courses", courses);
		} else {
			model.addAttribute("noCourses", "卧槽，查询不到课程");
		}
		return "courcesInfo";
	}
}
