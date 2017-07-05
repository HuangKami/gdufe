package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.Sutuo;
import kami.gdufe.model.User;

public interface SutuoService extends BaseService {

	List<Sutuo> getSutuos(User user);

}
