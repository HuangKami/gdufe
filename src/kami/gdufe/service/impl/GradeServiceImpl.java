package kami.gdufe.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import kami.gdufe.model.EnglishGrade;
import kami.gdufe.model.Grade;
import kami.gdufe.model.User;
import kami.gdufe.service.GradeService;

@Service
public class GradeServiceImpl extends BaseServiceImpl implements GradeService {
	// 存取成绩，key=学期，value=所在学期的所有成绩
	private Map<String, Map<String, List<Grade>>> gradesMap = new HashMap<String, Map<String, List<Grade>>>();
	private Map<String, EnglishGrade> englishGradeMap = new HashMap<String, EnglishGrade>();

	/**
	 * 获得成绩
	 */
	@Override
	public List<Grade> getGrades(User user, String stu_time) {
		// 检查map是否已查询过
		if (gradesMap.containsKey(user.getSno()) && gradesMap.get(user.getSno()).containsKey(stu_time)) {
			return gradesMap.get(user.getSno()).get(stu_time);
		}

		// 存放成绩列表
		List<Grade> grades = new ArrayList<Grade>();
		// 请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		if (!"整个大学".equals(stu_time)) {
			params.add("stu_time", stu_time);
		}

		// 获取返回的json数据
		JSONObject json = new JSONObject(restTemplate.postForObject(gradeUrl, params, String.class));

		// 返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取成绩数组
			JSONArray dataArray = json.getJSONArray("data");
			JSONObject data = null;
			// 循环遍历各科目成绩
			for (int i = 0; i < dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				Grade grade = new Grade();
				if (data.has("time")) {
					grade.setTime(data.getString("time"));
				}
				if (data.has("name")) {
					grade.setName(data.getString("name"));
				}
				if (data.has("score")) {
					grade.setScore(data.getInt("score"));
				}
				if (data.has("credit")) {
					grade.setCredit(data.getInt("credit"));
				}
				if (data.has("classCode")) {
					grade.setClassCode(data.getInt("classCode"));
				}
				if (data.has("dailyScore")) {
					grade.setDailyScore(data.getInt("dailyScore"));
				}
				if (data.has("expScore")) {
					grade.setExpScore(data.getInt("expScore"));
				}
				if (data.has("paperScore")) {
					grade.setPaperScore(data.getInt("paperScore"));
				}
				grades.add(grade);
			}
			Map<String, List<Grade>> gradeMap = new HashMap<String, List<Grade>>();
			gradeMap.put(stu_time, grades);
			gradesMap.put(user.getSno(), gradeMap);
			return grades;
		}
		return null;
	}

	/**
	 * 计算绩点
	 */
	@Override
	public String getGPA(List<Grade> grades) {
		Double gpa = 0.0;
		Double totalCredit = 0.0;
		for (Grade grade : grades) {
			if (grade.getScore() >= 60) {
				gpa += grade.getScore() * grade.getCredit();
			}
			totalCredit += grade.getCredit();
		}
		gpa = gpa / totalCredit;
		return transGPA(gpa);
	}

	private String transGPA(Double gpa) {
		if(gpa < 60) {
			return "0.00";
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		StringBuilder result = new StringBuilder();
		String gpaFM = df.format(gpa);
		if (gpaFM.charAt(0) == '1' && gpaFM.charAt(1) == '0' && gpaFM.charAt(2) == '0') {
			return "5.00";
		}
		int i = Integer.parseInt(gpaFM.charAt(0) + "");
		if (i <= 9 && i >= 6) {
			result.append(i - 5);
		}
		result.append("." + gpaFM.charAt(1) + gpaFM.charAt(3));
		return result.toString();
	}

	/**
	 * 
	 * @param zkzh
	 *            准考证号
	 * @param xm
	 *            姓名
	 * @return
	 */
	@Override
	public EnglishGrade getEnglishGrades(User user, String zkzh, String xm) {
		if (englishGradeMap.containsKey(user.getSno())) {
			return englishGradeMap.get(user.getSno());
		}

		// 请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("zkzh", zkzh);
		params.add("xm", xm);

		// 获取返回的json数据
		JSONObject json = new JSONObject(restTemplate.postForObject(gradeUrl, params, String.class));
		// 返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取数据json
			JSONObject data = json.getJSONObject("data");
			// 封装四六级对象
			EnglishGrade englishGrade = new EnglishGrade();
			if (data.has("name")) {
				englishGrade.setName(data.getString("name"));
			}
			if (data.has("school")) {
				englishGrade.setSchool(data.getString("school"));
			}
			if (data.has("level")) {
				englishGrade.setLevel(data.getString("level"));
			}
			if (data.has("cetId")) {
				englishGrade.setCetId(data.getString("cetId"));
			}
			if (data.has("score")) {
				englishGrade.setScore(data.getString("score"));
			}
			if (data.has("listenScore")) {
				englishGrade.setListenScore(data.getString("listenScore"));
			}
			if (data.has("readScore")) {
				englishGrade.setReadScore(data.getString("readScore"));
			}
			if (data.has("writeScore")) {
				englishGrade.setWriteScore(data.getString("writeScore"));
			}
			englishGradeMap.put(user.getSno(), englishGrade);
			return englishGrade;
		}
		return null;
	}
	
	@Override
	public void clear(User user) {
		if(gradesMap.containsKey(user.getSno())) {
			gradesMap.remove(user.getSno());
		}
		if(englishGradeMap.containsKey(user.getSno())) {
			englishGradeMap.remove(user.getSno());
		}
	}
}
