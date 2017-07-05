package kami.gdufe.service;

import java.util.List;

import kami.gdufe.model.Cash;
import kami.gdufe.model.CashRecord;
import kami.gdufe.model.User;

public interface CashService extends BaseService {
	Cash getCash(User user);
	List<CashRecord> getCashRecord(User user);
}
