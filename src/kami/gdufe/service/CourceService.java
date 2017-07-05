package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.Course;
import kami.gdufe.model.User;

public interface CourceService extends BaseService {
	List<Course> getCourses(User user, String stu_time);
}
