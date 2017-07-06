package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.BookBollowed;
import kami.gdufe.model.BookInfo;
import kami.gdufe.model.BookLocation;
import kami.gdufe.service.LibraryService;

@Controller
public class LibraryController extends BaseController {
	@Resource
	private LibraryService libraryService;

	@RequestMapping("/library")
	public String index() {
		return "library";
	}
	
	@RequestMapping("/hisBollowed")
	public String getHisBollowed(HttpServletRequest request, Model model) {
		List<BookBollowed> bookBolloweds = libraryService.getHisBolloweds(getSessionUser(request));
		if (bookBolloweds != null && bookBolloweds.size() > 0) {
			model.addAttribute("bookBolloweds", bookBolloweds);
		} else {
			model.addAttribute("noHisData", "卧槽，你没借过书啊");
		}
		return "hisBollowedInfo";
	}

	@RequestMapping("/nowBollowed")
	public String getNowBollowed(HttpServletRequest request, Model model) {
		List<BookBollowed> bookBolloweds = libraryService.getNowBolloweds(getSessionUser(request));
		if (bookBolloweds != null && bookBolloweds.size() > 0) {
			model.addAttribute("bookBolloweds", bookBolloweds);
		} else {
			model.addAttribute("noNowData", "卧槽，你当前没借书啊");
		}
		return "nowBollowedInfo";
	}

	@RequestMapping("/bookInfo")
	public String getBookInfo(HttpServletRequest request, String bookName, Model model) {
		List<BookInfo> bookInfos = libraryService.getBookInfo(getSessionUser(request), bookName);
		if (bookInfos != null && bookInfos.size() > 0) {
			model.addAttribute("bookInfos", bookInfos);
		} else {
			model.addAttribute("noBookInfo", "卧槽，没有该书籍信息啊");
		}
		return "bookInfo";
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
