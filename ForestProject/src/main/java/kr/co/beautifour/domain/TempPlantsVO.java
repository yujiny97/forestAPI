package kr.co.beautifour.domain;

public class TempPlantsVO {
	private int bid;
	private String uid;
	private String fskName;
	private String  fseName;
	private String  fsLifeTime;
	private String fsImg_1;
	private String  fsGbn;
	private String  fsClassname;
	private int isHerb;
	private int isPV; 
	private String writeD;
	public TempPlantsVO(){}
	public TempPlantsVO(String uid,String fskName,String fseName, String fsLifeTime,String fsImg_1,String fsGbn,String fsClassname,int isHerb) {
		this.uid=uid;
		this.fsClassname=fsClassname;
		this.fskName=fskName;
		this.fseName=fseName;
		this.fsLifeTime=fsLifeTime;
		this.fsImg_1=fsImg_1;
		this.fsGbn=fsGbn;
		this.isHerb=isHerb;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFskName() {
		return fskName;
	}
	public void setFskName(String fskName) {
		this.fskName = fskName;
	}
	public String getFseName() {
		return fseName;
	}
	public void setFseName(String fseName) {
		this.fseName = fseName;
	}
	public String getFsLifeTime() {
		return fsLifeTime;
	}
	public void setFsLifeTime(String fsLifeTime) {
		this.fsLifeTime = fsLifeTime;
	}
	public String getFsImg_1() {
		return fsImg_1;
	}
	public void setFsImg_1(String fsImg_1) {
		this.fsImg_1 = fsImg_1;
	}
	public String getFsGbn() {
		return fsGbn;
	}
	public void setFsGbn(String fsGbn) {
		this.fsGbn = fsGbn;
	}
	public String getFsClassname() {
		return fsClassname;
	}
	public void setFsClassname(String fsClassname) {
		this.fsClassname = fsClassname;
	}
	public int getIsHerb() {
		return isHerb;
	}
	public void setIsHerb(int isHerb) {
		this.isHerb = isHerb;
	}
	public int getIsPV() {
		return isPV;
	}
	public void setIsPV(int isPV) {
		this.isPV = isPV;
	}
	public String getWriteD() {
		return writeD;
	}
	public void setWriteD(String writeD) {
		this.writeD = writeD;
	}
}
