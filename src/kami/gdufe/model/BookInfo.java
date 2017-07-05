package kami.gdufe.model;

/**
 * 书籍信息
 * 
 * @author Kami
 *
 */
public class BookInfo {
	private String name;
	private String serial;
	private String publisher;
	private String author;
	private String macno;
	private int numAll;
	private int numCan;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMacno() {
		return macno;
	}

	public void setMacno(String macno) {
		this.macno = macno;
	}

	public int getNumAll() {
		return numAll;
	}

	public void setNumAll(int numAll) {
		this.numAll = numAll;
	}

	public int getNumCan() {
		return numCan;
	}

	public void setNumCan(int numCan) {
		this.numCan = numCan;
	}
}
