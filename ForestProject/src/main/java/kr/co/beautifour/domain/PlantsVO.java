package kr.co.beautifour.domain;

public class PlantsVO {
	private int pNum;
    private String fskName;
    private String fseName;
    private String fsLifeTime;
    private String fsImg_1;
    private String fsImg_2;
    private String fsGbn;
    private String fsClassname;
    private int isHerb;
   
    public int getpNum() {
        return pNum;
    }
    public void setpNum(int pNum) {
        this.pNum = pNum;
    }
    
    public String getfskName() {
        return fskName;
    }
    public void setfskName(String fskName) {
        this.fskName = fskName;
    }
    
    public String getfseName() {
        return fseName;
    }
    public void setfseName(String fseName) {
        this.fseName = fseName;
    }
    
    public String getfsLifeTime() {
        return fsLifeTime;
    }
    public void setfsLifeTime(String fsLifeTime) {
        this.fsLifeTime = fsLifeTime;
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
    
    public String getfsGbn() {
        return fsGbn;
    }
    public void setfsGbn(String fsGbn) {
        this.fsGbn = fsGbn;
    }
    
    public String getfsClassname() {
        return fsClassname;
    }
    public void setfsClassname(String fsClassname) {
        this.fsClassname = fsClassname;
    }
    
    public int getisHerb() {
        return isHerb;
    }
    public void setisHerb(int isHerb) {
        this.isHerb = isHerb;
    }
    
    @Override
    public String toString() {
        return "PlantsVO "+pNum+" "+fskName+" ";
    }

}
