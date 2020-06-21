package kr.co.beautifour.domain;

public class SelectHerbByDiseaseVO {
	private int HrbId;
	private String HrbName;
	private String DName;
	
	public int getHrbId() {
		return HrbId;
	}
	public void setHrbId(int HrbId) {
		this.HrbId = HrbId; 
	}
	
	public String getHrbName() {
		return HrbName;
	}
	public void setHrbName(String HrbName) {
		this.HrbName = HrbName; 
	}
	
	public String getDName() {
		return DName;
	}
	public void setDName(String DName) {
		this.DName = DName;
	}
}
