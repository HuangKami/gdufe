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

import kami.gdufe.model.Sutuo;
import kami.gdufe.model.User;
import kami.gdufe.service.SutuoService;
@Service
public class SutuoServiceImpl extends BaseServiceImpl implements SutuoService {
	private Map<String, List<Sutuo>> sutuoMap = new HashMap<String, List<Sutuo>>();
	
	/**
	 * 获取素拓信息
	 */
	@Override 
	public List<Sutuo> getSutuos(User user) {
		if(sutuoMap.containsKey(user.getSno())) {
			return sutuoMap.get(user.getSno());
		}
		
		//请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		//获取返回的json数据
		JSONObject json = new JSONObject(
				restTemplate.postForObject(sutuoUrl, params, String.class));
		//返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取成绩数组
			JSONArray dataArray = json.getJSONArray("data");
			JSONObject data = null;
			List<Sutuo> sutuos = new ArrayList<Sutuo>();
			// 循环遍历各科目成绩
			for (int i = 0; i < dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				Sutuo sutuo = new Sutuo();
				if(data.has("name")) {
					sutuo.setName(data.getString("name"));
				}
				if(data.has("requireScore")) {
					sutuo.setRequireScore(data.getString("requireScore"));
				}
				if(data.has("score")) {
					sutuo.setScore(data.getString("score"));
				}
				sutuos.add(sutuo);
			}
			sutuoMap.put(user.getSno(), sutuos);
			return sutuos;
		}
		return null;
	}
	
	@Override
	public void clear(User user) {
		if(sutuoMap.containsKey(user.getSno())) {
			sutuoMap.remove(user.getSno());
		}
	}
}
