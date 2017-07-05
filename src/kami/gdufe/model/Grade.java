package kami.gdufe.model;
/**
 * 课程成绩
 * @author Kami
 * @time 2017年7月1日
 */
public class Grade {
	private String name;
	private String time;
	private int score;
	private int credit;
	private int classCode;
	private int dailyScore;
	private int expScore;
	private int paperScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public int getDailyScore() {
		return dailyScore;
	}

	public void setDailyScore(int dailyScore) {
		this.dailyScore = dailyScore;
	}

	public int getExpScore() {
		return expScore;
	}

	public void setExpScore(int expScore) {
		this.expScore = expScore;
	}

	public int getPaperScore() {
		return paperScore;
	}

	public void setPaperScore(int paperScore) {
		this.paperScore = paperScore;
	}
}
