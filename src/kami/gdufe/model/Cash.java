package kami.gdufe.model;

/**
 * 校园卡现金余额
 * 
 * @author Kami
 * @time 2017年7月1日
 */
public class Cash {
	private String cardNum;
	private String cash;
	private String cardState;
	private String checkState;
	private String lossState;
	private String freezeState;

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getCardState() {
		return cardState;
	}

	public void setCardState(String cardState) {
		this.cardState = cardState;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public String getLossState() {
		return lossState;
	}

	public void setLossState(String lossState) {
		this.lossState = lossState;
	}

	public String getFreezeState() {
		return freezeState;
	}

	public void setFreezeState(String freezeState) {
		this.freezeState = freezeState;
	}
}
