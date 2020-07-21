package kr.co.beautifour.domain;

public class MybookVO {
	private int bookid;
	private String uid;
	private String story;
	private String picadd;
	private String forT;
	public MybookVO(){
	}
	public MybookVO(String uid,String story, String picadd, String forT){
		this.uid=uid;
		this.story=story;
		this.picadd=picadd;
		this.forT=forT;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getPicadd() {
		return picadd;
	}
	public void setPicadd(String picadd) {
		this.picadd = picadd;
	}
	public String getForT() {
		return forT;
	}
	public void setForT(String forT) {
		forT = forT;
	}
	
}
