package com.ssu.miso.vo;

import java.sql.Date;

public class CommentVO {
	private int cno;
	private int bno;
	private String name;
	private String content;
	private Date regdate;
	private String id;

	public CommentVO() {

	}

	public CommentVO(int bno, String name, String content, Date regdate, String id) {
		super();

		this.bno = bno;
		this.name = name;
		this.content = content;
		this.regdate = regdate;
		this.id = id;
	}

	public CommentVO(int cno, int bno, String name, String content, Date regdate, String id) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.name = name;
		this.content = content;
		this.regdate = regdate;
		this.id = id;
	}

	public final int getCno() {
		return cno;
	}

	public final int getBno() {
		return bno;
	}

	public final String getName() {
		return name;
	}

	public final String getContent() {
		return content;
	}

	public final Date getRegdate() {
		return regdate;
	}

	public final String getId() {
		return id;
	}

	public final void setCno(int cno) {
		this.cno = cno;
	}

	public final void setBno(int bno) {
		this.bno = bno;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public final void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", name=" + name + ", content=" + content + ", regdate="
				+ regdate + ", id=" + id + "]";
	}

}
