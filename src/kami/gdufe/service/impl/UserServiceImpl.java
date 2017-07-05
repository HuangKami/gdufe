package kami.gdufe.service.impl;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import kami.gdufe.model.User;
import kami.gdufe.service.UserService;
/**
 * 处理用户的业务逻辑
 * @author Kami
 * @time 2017年7月1日
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Override 
	public User getUser(User user) {
		//请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		//获取返回的json数据
		JSONObject json = new JSONObject(
				restTemplate.postForObject(userInfoUrl, params, String.class));
		//返回的json存在code字段和data字段，并且code=0
		if(json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			//获取数据json
			JSONObject data = json.getJSONObject("data");
			//封装User对象
			User loginUser = new User();
			loginUser.setSno(user.getSno());
			loginUser.setPwd(user.getPwd());
			if(data.has("name")) {
				loginUser.setName(data.getString("name"));
			}
			if(data.has("department")) {
				loginUser.setDepartment(data.getString("department"));
			}
			if(data.has("major")) {
				loginUser.setMajor(data.getString("major"));
			}
			if(data.has("classroom")) {
				loginUser.setClassroom(data.getString("classroom"));
			}
			if(data.has("sex")) {
				loginUser.setSex(data.getString("sex"));
			}
			if(data.has("namePy")) {
				loginUser.setNamePy(data.getString("namePy"));
			}
			if(data.has("birthday")) {
				loginUser.setBirthday(data.getString("birthday"));
			}
			if(data.has("party")) {
				loginUser.setParty(data.getString("party"));
			}
			if(data.has("nation")) {
				loginUser.setNation(data.getString("nation"));
			}
			if(data.has("education")) {
				loginUser.setEducation(data.getString("education"));
			}
			return loginUser;
		}
		return null;
	}

}
