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

import kami.gdufe.model.BookBollowed;
import kami.gdufe.model.BookInfo;
import kami.gdufe.model.BookLocation;
import kami.gdufe.model.PageBean;
import kami.gdufe.model.User;
import kami.gdufe.service.LibraryService;

@Service
public class LibraryServiceImpl extends BaseServiceImpl implements LibraryService {
	private Map<String, List<BookBollowed>> hisBollowedMap = new HashMap<String, List<BookBollowed>>();;
	private Map<String, List<BookBollowed>> nowBollowedMap = new HashMap<String, List<BookBollowed>>();
	private Map<String, List<BookInfo>> bookInfosMap = new HashMap<String, List<BookInfo>>();
	private Map<String, List<BookLocation>> bookLocationsMap = new HashMap<String, List<BookLocation>>();
	
	/**
	 * 搜索图书
	 * 
	 */
	@Override
	public List<BookInfo> getBookInfo(User user, String bookName) {
		if (bookInfosMap.containsKey(bookName)) {
			return bookInfosMap.get(bookName);
		}

		// 请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("bookName", bookName);

		// 获取返回的json数据
		JSONObject json = new JSONObject(restTemplate.postForObject(bookSearchUrl, params, String.class));
		// 返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取数据json
			JSONArray dataArray = json.getJSONArray("data");
			List<BookInfo> bookInfos = new ArrayList<BookInfo>();
			for(int i=0; i<dataArray.length(); i++) {
				JSONObject data = dataArray.getJSONObject(i);
				BookInfo bookInfo = new BookInfo();
				if (data.has("name")) {
					bookInfo.setName(data.getString("name"));
				}
				if (data.has("serial")) {
					bookInfo.setSerial(data.getString("serial"));
				}
				if (data.has("author")) {
					bookInfo.setAuthor(data.getString("author"));
				}
				if (data.has("publisher")) {
					bookInfo.setPublisher(data.getString("publisher"));
				}
				if (data.has("macno")) {
					bookInfo.setMacno(data.getString("macno"));
				}
				if (data.has("numAll")) {
					bookInfo.setNumAll(data.getInt("numAll"));
				}
				if (data.has("numCan")) {
					bookInfo.setNumCan(data.getInt("numCan"));
				}
				bookInfos.add(bookInfo);
			}
			
			bookInfosMap.put(bookName, bookInfos);
			return bookInfos;
		}
		return null;
	}
	
	/**
	 * 图书藏地和借阅状态
	 */
	@Override
	public List<BookLocation> getBookLocation(User user, String macno) {
		if (bookLocationsMap.containsKey(macno)) {
			return bookLocationsMap.get(macno);
		}

		// 请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("macno", macno);

		// 获取返回的json数据
		JSONObject json = new JSONObject(restTemplate.postForObject(bookInfoUrl, params, String.class));
		// 返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取数据json
			JSONArray dataArray = json.getJSONArray("data");
			List<BookLocation> bookLocations = new ArrayList<BookLocation>();
			JSONObject data = null;
			BookLocation bookLocation = null;
			for(int i=0; i<dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				bookLocation = new BookLocation();
				if(data.has("barId")) {
					bookLocation.setBarId(data.getString("barId"));
				}
				if(data.has("serial")) {
					bookLocation.setSerial(data.getString("serial"));
				}
				if(data.has("volume")) {
					bookLocation.setVolume(data.getString("volume"));
				}
				if(data.has("location")) {
					bookLocation.setLocation(data.getString("location"));
				}
				if(data.has("state")) {
					bookLocation.setState(data.getString("state"));
				}
				bookLocations.add(bookLocation);
			}
			
			bookLocationsMap.put(macno, bookLocations);
			return bookLocations;
		}
		return null;
	}
	
	/**
	 * 获取历史借阅
	 * @param user
	 * @return
	 */
	@Override
	public List<BookBollowed> getHisBolloweds(User user) {
		if(hisBollowedMap.containsKey(user.getSno())) {
			return hisBollowedMap.get(user.getSno());
		}
		List<BookBollowed> hisBolloweds = getBookBolloweds(user, bookHisUrl);
		if(hisBolloweds != null && hisBolloweds.size() > 0) {
			hisBollowedMap.put(user.getSno(), hisBolloweds);
		}
		return hisBolloweds;
	}
	
	/**
	 * 获取分页历史借阅
	 */
	@Override
	public List<BookBollowed> getHisBolloweds(User sessionUser, Integer pageNow) {
		List<BookBollowed> result = new ArrayList<BookBollowed>();
		List<BookBollowed> hisBolloweds = getHisBolloweds(sessionUser);
		if(hisBolloweds != null && hisBolloweds.size() > 0) {
			for (int i = 10 * (pageNow - 1);i < 10 * (pageNow - 1) + 10 && i < hisBolloweds.size(); i++) {
				result.add(hisBolloweds.get(i));
			}
		}
		return result;
	}
	
	/**
	 * 获取当前借阅
	 * @param user
	 * @return
	 */
	@Override
	public List<BookBollowed> getNowBolloweds(User user) {
		if(nowBollowedMap.containsKey(user.getSno())) {
			return nowBollowedMap.get(user.getSno());
		}
		List<BookBollowed> nowBolloweds = getBookBolloweds(user, bookNowUrl);
		if(nowBolloweds != null && nowBolloweds.size() > 0) {
			nowBollowedMap.put(user.getSno(), nowBolloweds);
		}
		return nowBolloweds;
	}
	
	/**
	 * 获取历史借阅分页信息
	 * @param user
	 * @param pageNow
	 * @return
	 */
	@Override
	public PageBean getHisPageBean(User user, Integer pageNow) {
		PageBean pageBean = new PageBean();
		if(getHisBolloweds(user) != null) {
			pageBean.setPageNow(pageNow);
			pageBean.setTotalCount(getHisBolloweds(user).size());
		}
		return pageBean;
	}
	
	/**
	 * 获取分页当前借阅
	 */
	@Override
	public List<BookBollowed> getNowBolloweds(User sessionUser, Integer pageNow) {
		List<BookBollowed> result = new ArrayList<BookBollowed>();
		List<BookBollowed> nowBolloweds = getNowBolloweds(sessionUser);
		if(nowBolloweds != null && nowBolloweds.size() > 0) {
			for (int i = 10 * (pageNow - 1);i < 10 * (pageNow - 1) + 10 && i < nowBolloweds.size(); i++) {
				result.add(nowBolloweds.get(i));
			}
		}
		return result;
	}
	
	/**
	 * 获取当前借阅分页信息
	 * @param user
	 * @param pageNow
	 * @return
	 */
	@Override
	public PageBean getNowPageBean(User user, Integer pageNow) {
		PageBean pageBean = new PageBean();
		if(getNowBolloweds(user) != null) {
			pageBean.setPageNow(pageNow);
			pageBean.setTotalCount(getNowBolloweds(user).size());
		}
		return pageBean;
	}
	
	/**
	 * 获取借阅信息
	 */
	private List<BookBollowed> getBookBolloweds(User user, String url) {
		List<BookBollowed> bookBolloweds = new ArrayList<BookBollowed>();
		//请求参数
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("sno", user.getSno());
		params.add("pwd", user.getPwd());
		//获取返回的json数据
		JSONObject json = new JSONObject(
				restTemplate.postForObject(url, params, String.class));
		//返回的json存在code字段和data字段，并且code=0
		if (json.has("code") && json.getInt("code") == 0 && json.has("data")) {
			// 获取成绩数组
			JSONArray dataArray = json.getJSONArray("data");
			JSONObject data = null;
			// 循环遍历各科目成绩
			for (int i = 0; i < dataArray.length(); i++) {
				data = dataArray.getJSONObject(i);
				BookBollowed bookBollowed = new BookBollowed();
				if(data.has("barId")) {
					bookBollowed.setBarId(data.getString("barId"));
				}
				if(data.has("name")) {
					bookBollowed.setName(data.getString("name"));
				}
				if(data.has("checkId")) {
					bookBollowed.setCheckId(data.getString("checkId"));
				}
				if(data.has("author")) {
					bookBollowed.setAuthor(data.getString("author"));
				}
				if(data.has("borrowedTime")) {
					bookBollowed.setBorrowedTime(data.getString("borrowedTime"));
				}
				if(data.has("returnTime")) {
					bookBollowed.setReturnTime(data.getString("returnTime"));
				}
				if(data.has("location")) {
					bookBollowed.setLocation(data.getString("location"));
				}
				if(data.has("renewTimes")) {
					bookBollowed.setRenewTimes(data.getInt("renewTimes"));
				}
				bookBolloweds.add(bookBollowed);
			}
			return bookBolloweds;
		}
		return null;
	}
	
	/**
	 * 获取分页书籍信息
	 */
	@Override
	public List<BookInfo> getBookInfo(User sessionUser, String bookName, Integer pageNow) {
		List<BookInfo> result = new ArrayList<BookInfo>();
		List<BookInfo> bookInfos = getBookInfo(sessionUser, bookName);
		if(bookInfos != null && bookInfos.size() > 0) {
			for (int i = 10 * (pageNow - 1);i < 10 * (pageNow - 1) + 10 && i < bookInfos.size(); i++) {
				result.add(bookInfos.get(i));
			}
		}
		return result;
	}
	
	/**
	 * 获取分页信息
	 * @param user
	 * @param stu_time
	 * @param pageNow
	 * @return
	 */
	@Override
	public PageBean getPageBean(User user, String bookName, Integer pageNow) {
		PageBean pageBean = new PageBean();
		if(getBookInfo(user, bookName) != null) {
			pageBean.setPageNow(pageNow);
			pageBean.setTotalCount(getBookInfo(user, bookName).size());
		}
		return pageBean;
	}
	
	@Override
	public void clear(User user) {
		if(bookInfosMap.size() > 0) {
			bookInfosMap.clear();
		}
		if(bookLocationsMap.size() > 0) {
			bookLocationsMap.clear();
		}
		if(hisBollowedMap.containsKey(user.getSno())) {
			hisBollowedMap.remove(user.getSno());
		}
		if(nowBollowedMap.containsKey(user.getSno())) {
			nowBollowedMap.remove(user.getSno());
		}
	}
}
