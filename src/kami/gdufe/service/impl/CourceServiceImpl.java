package kami.gdufe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import kami.gdufe.model.Course;
import kami.gdufe.model.User;
import kami.gdufe.service.CourceService;
@Service
public class CourceServiceImpl extends BaseServiceImpl implements CourceService {
	// 存取成绩，<学号，<学期，所在学期的所有课程>>
	private Map<String, Map<String, List<Course>>> coursesMap = new HashMap<String, Map<String,List<Course>>>();
	
	@Override
	public List<Course> getCourses(User user, String stu_time) {
		//检查map是否已查询过
		if(coursesMap.containsKey(user.getSno()) && coursesMap.get(user.getSno()).containsKey(stu_time)) {
			return coursesMap.get(user.getSno()).get(stu_time);
		}
	
		//存放成绩列表
		List<Course> courses = new ArrayList<Course>();
		// 请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		params.add("stu_time", stu_time);
		

		// 获取返回的json数据
		JSONObject json = new JSONObject(restTemplate.postForObject(courseUrl, params, String.class));

		// 返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取课程数组
			JSONArray dataArray = json.getJSONArray("data");
			JSONObject data = null;
			//循环遍历各个课程
			for (int i=0; i<dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				Course course = new Course();
				if(data.has("name")) {
					course.setName(data.getString("name"));
				}
				if(data.has("teacher")) {
					course.setTeacher(data.getString("teacher"));
				}
				if(data.has("period")) {
					course.setPeriod(data.getString("period"));
				}
				if(data.has("location")) {
					course.setLocation(data.getString("location"));
				}
				if(data.has("dayInWeek")) {
					course.setDayInWeek(data.getInt("dayInWeek"));
				}
				if(data.has("startSec")) {
					course.setStartSec(data.getInt("startSec"));
				}
				if(data.has("endSec")) {
					course.setEndSec(data.getInt("endSec"));
				}
				courses.add(course);
			}
			Map<String, List<Course>> courseMap = new HashMap<String, List<Course>>();
			courseMap.put(stu_time, courses);
			coursesMap.put(user.getSno(), courseMap);
			return courses;
		}
		return null;
	}
	
	@Override
	public void clear(User user) {
		if(coursesMap.containsKey(user.getSno())) {
			coursesMap.remove(user.getSno());
		}
	}
}
