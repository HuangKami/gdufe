package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.BookBollowed;
import kami.gdufe.model.BookInfo;
import kami.gdufe.model.BookLocation;
import kami.gdufe.model.PageBean;
import kami.gdufe.model.User;

public interface LibraryService extends BaseService {

	List<BookBollowed> getHisBolloweds(User user);

	List<BookBollowed> getNowBolloweds(User user);

	List<BookInfo> getBookInfo(User user, String bookName);

	List<BookLocation> getBookLocation(User user, String macno);

	List<BookInfo> getBookInfo(User sessionUser, String stu_time, Integer pageNow);

	PageBean getPageBean(User user, String bookName, Integer pageNow);

	List<BookBollowed> getHisBolloweds(User sessionUser, Integer pageNow);

	List<BookBollowed> getNowBolloweds(User sessionUser, Integer pageNow);

	PageBean getHisPageBean(User user, Integer pageNow);

	PageBean getNowPageBean(User user, Integer pageNow);


}
