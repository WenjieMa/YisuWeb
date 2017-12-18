package com.pojo.arranged;

import java.sql.Timestamp;

public class ChatingInfo {
	String uNicheng;
	String recordText;
	public String getuNicheng() {
		return uNicheng;
	}
	public void setuNicheng(String uNicheng) {
		this.uNicheng = uNicheng;
	}
	Timestamp recordTime;
	public String getRecordText() {
		return recordText;
	}
	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
}
