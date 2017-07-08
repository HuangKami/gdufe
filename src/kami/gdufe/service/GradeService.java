package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.EnglishGrade;
import kami.gdufe.model.Grade;
import kami.gdufe.model.PageBean;
import kami.gdufe.model.User;

public interface GradeService extends BaseService {
	List<Grade> getGrades(User user, String stu_time);

	EnglishGrade getEnglishGrades(User user, String zkzh, String xm);

	String getGPA(List<Grade> grades);

	List<Grade> getGrades(User sessionUser, String stu_time, Integer pageNow);

	PageBean getPageBean(User user, String stu_time, Integer pageNow);

}
