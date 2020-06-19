package kr.co.beautifour.domain;

public class UserVO {
	private String UID;
	private String PW;
	private String UName;
	private String gender;
	private int age;
	
	public UserVO(String UID, String PW,String UName,String gender,int age) {
		this.UID=UID;
		this.PW=PW;
		this.age=age;
		this.gender=gender;
		this.UName=UName;
	}
	public UserVO() {
		
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
