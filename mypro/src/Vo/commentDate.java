package Vo;

import java.util.Date;

public class commentDate {

	private int no;
	private int comenNo;
	private String id;
	private String content;
	private Date regDate;
	private int recom_cnt;
	private String gCode;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getComenNo() {
		return comenNo;
	}
	public void setComenNo(int comenNo) {
		this.comenNo = comenNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRecom_cnt() {
		return recom_cnt;
	}
	public void setRecom_cnt(int recom_cnt) {
		this.recom_cnt = recom_cnt;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	
}
