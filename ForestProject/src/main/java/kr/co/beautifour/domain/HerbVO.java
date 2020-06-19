package kr.co.beautifour.domain;

import java.util.ArrayList;
import java.util.List;

public class HerbVO {
	private int HrbId;
	private String HrbName;
	private String mng;
	private String caution;
	private String internal;
	private String external;
	private String fsImg_1;
    private String fsImg_2;
    private ArrayList<String> country= new ArrayList<String>();
	
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
	
	public String getmng() {
		return mng;
	}
	public void setmng(String mng) {
		this.mng = mng; 
	}
	
	public String getcaution() {
		return caution;
	}
	public void setcaution(String caution) {
		this.caution = caution; 
	}
	
	public String getinternal() {
		return internal;
	}
	public void setinternal(String internal) {
		this.internal = internal; 
	}
	
	public String getexternal() {
		return external;
	}
	public void setexternal(String external) {
		this.external = external; 
	}
	
	public String getfsImg_1() {
        return fsImg_1;
    }
    public void setfsImge_1(String fsImg_1) {
        this.fsImg_1 = fsImg_1;
    }
    
    public String getfsImg_2() {
        return fsImg_2;
    }
    public void setfsImge_2(String fsImg_2) {
        this.fsImg_2 = fsImg_2;
    }
    
    public ArrayList<String> getcountry() {
        return country;
    }
    public void setcountry(String country) {
        this.country.add(country);
    }
}
