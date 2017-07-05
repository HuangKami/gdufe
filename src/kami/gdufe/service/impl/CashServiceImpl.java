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

import kami.gdufe.model.Cash;
import kami.gdufe.model.CashRecord;
import kami.gdufe.model.User;
import kami.gdufe.service.CashService;
@Service
public class CashServiceImpl extends BaseServiceImpl implements CashService {
	//余额
	private Map<String, Cash> cashMap = new HashMap<String, Cash>();;
	//当天交易记录
	private Map<String, List<CashRecord>> cashRecordMap = new HashMap<String, List<CashRecord>>();
	
	@Override 
	public Cash getCash(User user) {
		if(cashMap.containsKey(user.getSno())) {
			return cashMap.get(user.getSno());
		}
		
		//请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		//获取返回的json数据
		JSONObject json = new JSONObject(
				restTemplate.postForObject(cashUrl, params, String.class));
		//返回的json存在code字段和data字段，并且code=0
		if(json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			//获取数据json
			JSONObject data = json.getJSONObject("data");
			//封装饭卡余额对象
			Cash cash = new Cash();
			if(data.has("cardNum")) {
				cash.setCardNum(data.getString("cardNum"));
			}
			if(data.has("cash")) {
				cash.setCash(data.getString("cash"));
			}
			if(data.has("cardState")) {
				cash.setCardState(data.getString("cardState"));
			}
			if(data.has("checkState")) {
				cash.setCheckState(data.getString("checkState"));
			}
			if(data.has("lossState")) {
				cash.setLossState(data.getString("lossState"));
			}
			if(data.has("freezeState")) {
				cash.setFreezeState(data.getString("freezeState"));
			}
			cashMap.put(user.getSno(), cash);
			return cash;
		}
		return null;
	}
	
	@Override 
	public List<CashRecord> getCashRecord(User user) {
		if(cashRecordMap.containsKey(user.getSno())) {
			return cashRecordMap.get(user.getSno());
		}
		
		//请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		params.add("cardNum", getCash(user).getCardNum());
		//获取返回的json数据
		JSONObject json = new JSONObject(
				restTemplate.postForObject(cashRecordUrl, params, String.class));
		//返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取成绩数组
			JSONArray dataArray = json.getJSONArray("data");
			JSONObject data = null;
			List<CashRecord> cashRecords = new ArrayList<CashRecord>();
			// 循环遍历各科目成绩
			for (int i = 0; i < dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				CashRecord cashRecord = new CashRecord();
				if(data.has("time")) {
					cashRecord.setTime(data.getString("time"));
				}
				if(data.has("shop")) {
					cashRecord.setShop(data.getString("shop"));
				}
				if(data.has("change")) {
					cashRecord.setChange(data.getString("change"));
				}
				if(data.has("cash")) {
					cashRecord.setCash(data.getString("cash"));
				}
				cashRecords.add(cashRecord);
			}
			cashRecordMap.put(user.getSno(), cashRecords);
			return cashRecords;
		}
		return null;
	}
	
	@Override
	public void clear(User user) {
		if(cashMap.containsKey(user.getSno())) {
			cashMap.remove(user.getSno());
		}
		if(cashRecordMap.containsKey(user.getSno())) {
			cashRecordMap.remove(user.getSno());
		}
	}
}
