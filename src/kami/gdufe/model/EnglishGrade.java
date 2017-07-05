package kami.gdufe.model;
/**
 * 四六级
 * @author Kami
 * @time 2017年7月1日
 */
public class EnglishGrade {
	private String name;
	private String school;
	private String level;
	private String cetId;
	private String score;
	private String listenScore;
	private String readScore;
	private String writeScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCetId() {
		return cetId;
	}

	public void setCetId(String cetId) {
		this.cetId = cetId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getListenScore() {
		return listenScore;
	}

	public void setListenScore(String listenScore) {
		this.listenScore = listenScore;
	}

	public String getReadScore() {
		return readScore;
	}

	public void setReadScore(String readScore) {
		this.readScore = readScore;
	}

	public String getWriteScore() {
		return writeScore;
	}

	public void setWriteScore(String writeScore) {
		this.writeScore = writeScore;
	}
}
