package kr.co.beautifour.domain;

public class CommentVO {
	private int bid;
	private String uid;
	private String  detail;
	private String writeD;
	private int cid;
	private String cmuid;
	public CommentVO(){}
	public CommentVO(int bid,String uid,String detail, String cmuid) {
		this.bid=bid;
		this.cmuid=cmuid;
		this.uid=uid;
		this.detail=detail;
	}

	public String getWriteD() {
		return writeD;
	}
	public void setWriteD(String writeD) {
		this.writeD = writeD;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCmuid() {
		return cmuid;
	}
	public void setCmuid(String cmuid) {
		this.cmuid = cmuid;
	}
}
