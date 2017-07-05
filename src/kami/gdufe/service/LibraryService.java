package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.BookBollowed;
import kami.gdufe.model.BookInfo;
import kami.gdufe.model.BookLocation;
import kami.gdufe.model.User;

public interface LibraryService extends BaseService {

	List<BookBollowed> getHisBolloweds(User user);

	List<BookBollowed> getNowBolloweds(User user);

	List<BookInfo> getBookInfo(User user, String bookName);

	List<BookLocation> getBookLocation(User user, String macno);


}
