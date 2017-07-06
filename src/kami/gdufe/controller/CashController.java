package kami.gdufe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kami.gdufe.model.Cash;
import kami.gdufe.model.CashRecord;
import kami.gdufe.service.CashService;
@Controller
public class CashController extends BaseController {
	@Resource
	private CashService cashService;
	
	/**
	 * 查询余额
	 */
	@RequestMapping("/cashInfo")
	public String getCash(HttpServletRequest request, Model model) {
		Cash cash = cashService.getCash(getSessionUser(request));
		if(cash != null) {
			model.addAttribute("cash", cash);
		} else {
			model.addAttribute("noCash", "卧槽，查询不到余额");
		}
		return "cashInfo";
	}
	
	/**
	 * 查询交易记录
	 */
	@RequestMapping("/cashRecordInfo")
	public String getCashRecord(HttpServletRequest request, Model model) {
		List<CashRecord> cashRecords = cashService.getCashRecord(getSessionUser(request));
		if(cashRecords != null && cashRecords.size() > 0) {
			model.addAttribute("cashRecords", cashRecords);
		} else {
			model.addAttribute("noCashRecord", "卧槽，查询不到交易记录");
		}
		return "cashRecordInfo";
	}
}
