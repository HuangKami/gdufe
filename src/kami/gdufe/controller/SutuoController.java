package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.Sutuo;
import kami.gdufe.service.SutuoService;
@Controller
public class SutuoController extends BaseController {
	@Resource
	private SutuoService sutuoService;
	
	@RequestMapping("sutuosInfo")
	public String getSutuos(HttpServletRequest request, Model model) {
		List<Sutuo> sutuos = sutuoService.getSutuos(getSessionUser(request));
		if(sutuos != null && sutuos.size() > 0) {
			model.addAttribute("sutuos", sutuos);
		} else {
			model.addAttribute("noSutos", "卧槽，查询不到素拓信息");
		}
		return "sutuosInfo";
	}
}
