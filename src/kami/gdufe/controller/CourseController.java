package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kami.gdufe.model.Course;
import kami.gdufe.service.CourceService;

@Controller
public class CourseController extends BaseController {
	@Resource
	private CourceService courceService;
	
	@RequestMapping("course")
	public String index() {
		return "course";
	}
	
	@ResponseBody
	@RequestMapping("/courcesInfo")
	public List<Course> getCources(HttpServletRequest request, 
			Model model, String stu_time) {
		return courceService.getCourses(getSessionUser(request), stu_time);
	}
}
