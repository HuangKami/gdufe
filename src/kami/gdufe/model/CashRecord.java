package kami.gdufe.model;
/**
 * 校园卡当日交易记录
 * @author Kami
 * @time 2017年7月1日
 */
public class CashRecord {
	private String time;
	private String shop;
	private String change;
	private String cash;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}
}
