package com.ssu.miso.vo;

import java.sql.Date;

public class TourVO {
	private int tno;
	private String school;
	private String name;
	private String phone;
	private String visitdate;
	private int pnum;

	public TourVO() {

	}

	public TourVO(String school, String name, String phone, String visitdate, int pnum) {
		super();
		this.school = school;
		this.name = name;
		this.phone = phone;
		this.visitdate = visitdate;
		this.pnum = pnum;
	}

	public TourVO(int tno, String school, String name, String phone, String visitdate, int pnum) {
		super();
		this.tno = tno;
		this.school = school;
		this.name = name;
		this.phone = phone;
		this.visitdate = visitdate;
		this.pnum = pnum;
	}

	public final int getTno() {
		return tno;
	}

	public final String getSchool() {
		return school;
	}

	public final String getName() {
		return name;
	}

	public final String getPhone() {
		return phone;
	}

	public final String getVisitdate() {
		return visitdate;
	}

	public final int getPnum() {
		return pnum;
	}

	public final void setTno(int tno) {
		this.tno = tno;
	}

	public final void setSchool(String school) {
		this.school = school;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final void setVisitdate(String visitdate) {
		this.visitdate = visitdate;
	}

	public final void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "TourVO [tno=" + tno + ", school=" + school + ", name=" + name + ", phone=" + phone + ", visitdate="
				+ visitdate + ", pnum=" + pnum + "]";
	}

}
