package kami.gdufe.model;

/**
 * 历史借阅和当前借阅
 * 
 * @author Kami
 *
 */
public class BookBollowed {
	private String barId;
	private String name;
	private String author;
	private String borrowedTime;
	private String returnTime;
	private String location;
	private String checkId;

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBorrowedTime() {
		return borrowedTime;
	}

	public void setBorrowedTime(String borrowedTime) {
		this.borrowedTime = borrowedTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public int getRenewTimes() {
		return renewTimes;
	}

	public void setRenewTimes(int renewTimes) {
		this.renewTimes = renewTimes;
	}

	private int renewTimes;
}
