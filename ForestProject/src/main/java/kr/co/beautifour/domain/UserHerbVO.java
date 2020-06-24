package kr.co.beautifour.domain;
import java.util.ArrayList;

public class UserHerbVO {

	
   private int HrbId;
   private String HrbName;
   private int Did;
   private String DName;
   private String fsImg_1;
   private ArrayList<String> DName_li = new ArrayList<String>();

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
   
   public int getDid() {
      return Did;
   }
   public void setDid(int Did) {
      this.Did = Did;
   }
   
   public String getDName() {
      return DName;
   }
   public void setDName(String DName) {
      this.DName = DName;
   }
   
   public String getfsImg_1() {
        return fsImg_1;
    }
    public void setfsImge_1(String fsImg_1) {
        this.fsImg_1 = fsImg_1;
    }
    
    public ArrayList<String> getDName_li() {
      return DName_li;
   }
   public void setDName_li(String DName) {
      this.DName_li.add(DName);
   }
}
