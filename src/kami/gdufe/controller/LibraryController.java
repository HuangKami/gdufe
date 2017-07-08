package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kami.gdufe.model.BookBollowed;
import kami.gdufe.model.BookInfo;
import kami.gdufe.model.BookLocation;
import kami.gdufe.model.PageBean;
import kami.gdufe.service.LibraryService;

@Controller
public class LibraryController extends BaseController {
	@Resource
	private LibraryService libraryService;

	@RequestMapping("/library")
	public String index() {
		return "library";
	}

	@RequestMapping("/search")
	public String search() {
		return "searchBook";
	}

	/**
	 * 获取历史借阅
	 * @param request
	 * @param pageNow
	 * @param model
	 * @return
	 */
	@RequestMapping("/hisBollowed")
	public String getHisBollowed(HttpServletRequest request, Integer pageNow, Model model) {
		List<BookBollowed> bookBolloweds = libraryService.getHisBolloweds(getSessionUser(request), pageNow);
		if (bookBolloweds != null && bookBolloweds.size() > 0) {
			model.addAttribute("bookBolloweds", bookBolloweds);
			model.addAttribute("pageBean", libraryService.getHisPageBean(getSessionUser(request), pageNow));
		} else {
			model.addAttribute("noHisData", "卧槽，你没借过书啊");
		}
		return "hisBollowedInfo";
	}

	/**
	 * 获取当前借阅
	 * @param request
	 * @param pageNow
	 * @param model
	 * @return
	 */
	@RequestMapping("/nowBollowed")
	public String getNowBollowed(HttpServletRequest request, Integer pageNow, Model model) {
		List<BookBollowed> bookBolloweds = libraryService.getNowBolloweds(getSessionUser(request));
		if (bookBolloweds != null && bookBolloweds.size() > 0) {
			model.addAttribute("bookBolloweds", bookBolloweds);
			model.addAttribute("pageBean", libraryService.getNowPageBean(getSessionUser(request), pageNow));
		} else {
			model.addAttribute("noNowData", "卧槽，你当前没借书啊");
		}
		return "nowBollowedInfo";
	}

	@ResponseBody
	@RequestMapping("/bookInfo")
	public List<BookInfo> getBookInfo(HttpServletRequest request, String bookName, Integer pageNow) {
		return  libraryService.getBookInfo(getSessionUser(request), bookName, pageNow);
	}
	
	@ResponseBody
	@RequestMapping("/getBookPage")
	public PageBean getPage(HttpServletRequest request, String bookName, Integer pageNow) {
		return  libraryService.getPageBean(getSessionUser(request), bookName, pageNow);
	}

	@RequestMapping("/bookLocation")
	public String getBookLocation(HttpServletRequest request, String macno, Model model) {
		List<BookLocation> bookLocations = libraryService.getBookLocation(getSessionUser(request), macno);
		if (bookLocations != null && bookLocations.size() > 0) {
			model.addAttribute("bookLocations", bookLocations);
		} else {
			model.addAttribute("noBookLocation", "卧槽，没有该书籍详细信息啊");
		}
		return "bookLocation";
	}
}
