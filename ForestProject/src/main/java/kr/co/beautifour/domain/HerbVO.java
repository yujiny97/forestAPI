package kr.co.beautifour.domain;

import java.util.ArrayList;

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
    private ArrayList<String> disease = new ArrayList<String>();
	private String Img1;
	private String Img2;
	private String Img3;
	private String medicinal;
    
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
    
    public ArrayList<String> getdisease() {
        return disease;
    }
    public void setdisease(String disease) {
        this.disease.add(disease);
    }
    
    public String getImg1() {
        return Img1;
    }
    public void setImg1(String Img1) {
        this.Img1 = Img1;
    }
    
    public String getImg2() {
        return Img2;
    }
    public void setImg2(String Img2) {
        this.Img2 = Img2;
    }
    
    public String getImg3() {
        return Img3;
    }
    public void setImg3(String Img3) {
        this.Img3 = Img3;
    }
    
    public String getMedicinal() {
        return medicinal;
    }
    public void setMedicinal(String medicinal) {
        this.medicinal = medicinal;
    }
}
