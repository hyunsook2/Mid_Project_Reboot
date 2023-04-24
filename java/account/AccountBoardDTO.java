package account;

import java.util.Date;

public class AccountBoardDTO {
	private String id;
	private int deptn;
	private String name;
	private String pass;
	private int grade;
	private Date in_d;
	private Date out_d;
	private Date bday;
	private String pnum;
	private String ad;
	private String off_d;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDeptn() {
		return deptn;
	}
	public void setDeptn(int deptn) {
		this.deptn = deptn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getIn_d() {
		return in_d;
	}
	public void setIn_d(Date in_d) {
		this.in_d = in_d;
	}
	public Date getOut_d() {
		return out_d;
	}
	public void setOut_d(Date out_d) {
		this.out_d = out_d;
	}
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getOff_d() {
		return off_d;
	}
	public void setOff_d(String off_d) {
		this.off_d = off_d;
	}

	

}
