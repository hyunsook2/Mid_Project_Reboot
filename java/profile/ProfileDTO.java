package profile;

import java.sql.Date;

public class ProfileDTO {
   private String id;
   private String name;
   private String password;
   private String ad;
   private int pnum;
   private Date in_d;
   private Date out_d;
   private Date bday;
   private int grade;
   private int deptn;
   

   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPassword() {
	   return password;
   }
   public void setPassword(String password) {
	   this.password = password;
   }
   public String getAd() {
	   return ad;
   }
   public void setAd(String ad) {
      this.ad = ad;
   }
   public int getPnum() {
      return pnum;
   }
   public void setPnum(int pnum) {
      this.pnum = pnum;
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
   public int getGrade() {
      return grade;
   }
   public void setGrade(int grade) {
      this.grade = grade;
   }
   public int getDeptn() {
      return deptn;
   }
   public void setDeptn(int deptn) {
      this.deptn = deptn;
   }
   
   
   
}