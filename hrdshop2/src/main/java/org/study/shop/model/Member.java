package org.study.shop.model;

import java.sql.Date;

public class Member {

	private String member_id;
	private String member_name;
	private String member_pw1;
	private Date member_join_date;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Date getMember_join_date() {
		return member_join_date;
	}
	public void setMember_join_date(Date member_join_date) {
		this.member_join_date = member_join_date;
	}
	public String getMember_pw1() {
		return member_pw1;
	}
	public void setMember_pw1(String member_pw1) {
		this.member_pw1 = member_pw1;
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_name=" + member_name + ", member_pw1=" + member_pw1
				+ ", member_join_date=" + member_join_date + "]";
	}

	
}
