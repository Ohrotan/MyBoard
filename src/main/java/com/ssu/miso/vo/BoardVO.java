package com.ssu.miso.vo;

public class BoardVO {
	private int bno;
	private String school;
	private String visitdate;
	private String pic;
	private String content;
	private String regdate;

	public BoardVO() {

	}

	public BoardVO(String school, String visitdate, String pic, String content) {
		super();
		this.school = school;
		this.visitdate = visitdate;
		this.pic = pic;
		this.content = content;
	}

	public BoardVO(int bno, String school, String visitdate, String pic, String content, String regdate) {
		super();
		this.bno = bno;
		this.school = school;
		this.visitdate = visitdate;
		this.pic = pic;
		this.content = content;
		this.regdate = regdate;
	}

	public final int getBno() {
		return bno;
	}

	public final String getSchool() {
		return school;
	}

	public final String getVisitdate() {
		return visitdate;
	}

	public final String getPic() {
		return pic;
	}

	public final String getRegdate() {
		return regdate;
	}

	public final String getContent() {
		return content;
	}

	public final void setBno(int bno) {
		this.bno = bno;
	}

	public final void setSchool(String school) {
		this.school = school;
	}

	public final void setVisitDate(String visitdate) {
		this.visitdate = visitdate;
	}

	public final void setPic(String pic) {
		this.pic = pic;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", school=" + school + ", visitdate=" + visitdate + ", pic=" + pic + ", content="
				+ content + ", regdate=" + regdate + "]";
	}

}
