package kr.co.beautifour.web;

import javax.inject.Inject;


import kr.co.beautifour.dao.HerbDao;
import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.PlantsVO;
import kr.co.beautifour.domain.SelectHerbByDiseaseVO;
import kr.co.beautifour.domain.TherapyVO;
import kr.co.beautifour.domain.UserVO;
import kr.co.beautifour.domain.AllHerbVO;
import kr.co.beautifour.domain.DiseaseVO;
import kr.co.beautifour.domain.UserHerbVO;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import kr.co.beautifour.domain.UserHerbVO;

@Controller
public class PlantsController {
   
    @Inject
    private PlantsDao dao;
    
    @Inject
    private HerbDao hdao;
    
    //占쏙옙체 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쌍깍옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllPlants", method = RequestMethod.GET)
    public List<PlantsVO> getAllPlants(){
    	List<PlantsVO> result =  dao.selectAllPlants();    
        return result;
    }
  //占쏙옙체 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쌍깍옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllPlantsByMok", method = RequestMethod.GET)
    public List<PlantsVO> getAllPlantsByMok(){  
    	List<PlantsVO> result =  dao.selectAllPlantsByMok();    
        return result;  
    }
    
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllPlantsByCho", method = RequestMethod.GET)
    public List<PlantsVO> getAllPlantsByCho(){  
    	List<PlantsVO> result =  dao.selectAllPlantsByCho();    
        return result;  
    }
    
  //占싼곤옙占쏙옙 占식뱄옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍깍옙 - pNum占쏙옙占쏙옙 占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getPlants", method = RequestMethod.GET)
    public List<PlantsVO> getPlants(HttpServletRequest request){
    	int no=0;
    	if(request.getParameter("pNum")!=null) {
    		no = Integer.parseInt(request.getParameter("pNum"));
    		
    	}
         List<PlantsVO> result =  dao.selectPlants(no);    
        return result;
    }
    
    //占싼곤옙占쏙옙 占식뱄옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍깍옙 - pNum占쏙옙占쏙옙 占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllPlantsInfo", method = RequestMethod.GET)
    public List<PlantsVO> getAllPlantsInfo(){
    	
         List<PlantsVO> result =  dao.selectAllPlantsInfo();    
        return result;
    }
    
    //占쏙옙체 占쏙옙援듸옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍깍옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllHerb", method = RequestMethod.GET)
    public List<AllHerbVO> getAllHerb(){
    	List<AllHerbVO> result =  hdao.selectAllHerb();    
        return result;
    }
    
    //占싼곤옙占쏙옙 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쌍깍옙 - HrbId占쏙옙 占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getHerbs", method = RequestMethod.GET)
    public HerbVO getHerbs(HttpServletRequest request){
        int no=0;
    	//占쏙옙占쏙옙 占싼겨뱄옙占쏙옙 占쏙옙占쏙옙 占쌍다몌옙
    	if(request.getParameter("HrbId")!=null) {
    		no = Integer.parseInt(request.getParameter("HrbId"));
    		
    	}
         HerbVO result =  hdao.selectHerbs(no);
         List<HerbContVO> result1 = hdao.selectHerbsCountry(no);
         List<TherapyVO> result2 = hdao.selectTherapy(no); 
         for(int i=0;i<result1.size();i++) {
        	 result.setcountry(result1.get(i).getCountry());
         }
         for(int i=0;i<result2.size();i++) {
        	 result.setdisease(result2.get(i).getDName());
         }
        return result;
    }
    
    //占싱몌옙占쏙옙占쏙옙 占식뱄옙 占싯삼옙占싹깍옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getPlantsbyName", method = RequestMethod.GET)
    public List<PlantsVO> getPlantsbyName(HttpServletRequest request){
        
        String search = request.getParameter("search");
         List<PlantsVO> result =  dao.selectsearchPlants(search);
         
        return result;
    }
    
    //占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쌍깍옙
    @ResponseBody
    @RequestMapping(value = "/Disease/getDList", method = RequestMethod.GET)
    public List<DiseaseVO> getDList(HttpServletRequest request){
        String search = request.getParameter("search");
    	List<DiseaseVO> result =  hdao.selectDisease(search);
        return result;
    }
    
    //占쏙옙占싱몌옙占쏙옙占쏙옙 占쌔댐옙占싹댐옙 占식뱄옙 占쏙옙占쏙옙占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getPlantsbyDisease", method = RequestMethod.GET)
    public List<SelectHerbByDiseaseVO> getPlantsbyDisease(HttpServletRequest request){
    	String search = request.getParameter("search");
    	List<SelectHerbByDiseaseVO> result =  hdao.selectHerbsbyDisease(search);
        return result;
    }
    

  //占쏙옙占싱몌옙占쏙옙占쏙옙 占쌔댐옙占싹댐옙 占식뱄옙 占쏙옙占쏙옙占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getUserHerbs", method = RequestMethod.POST)
    public Map<String,Object> getUserHerbs(@RequestBody Map<String, Object> param){
    	Map<String, Object> res=new HashMap();
    	String uid = (String)(param.get("uid"));
    	List<UserHerbVO> result;
		try {
		result=hdao.selectUserHerb(uid);
		for(int i=0;i<result.size();i++) {
			result.get(i).getDName_li().add(result.get(i).getDName());
		}
		for(int i=0;i<result.size()-1;i++) {
			if(result.get(i).getHrbId()==result.get(i+1).getHrbId()) {
				result.get(i).getDName_li().add(result.get(i+1).getDName());
				result.remove(i+1);
				i = i-1;
			}
		}
		}catch(Exception ex) {//�뿉�윭媛� 諛쒖깮�븷 寃쎌슦
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", result);
		return res;
    }
    
    //占쏙옙占싱몌옙占쏙옙占쏙옙 占쌔댐옙占싹댐옙 占식뱄옙 占쏙옙占쏙옙占쏙옙占쏙옙
    @ResponseBody
    @RequestMapping(value = "/Disease/insertDbyID", method = RequestMethod.POST)
    public HashMap<String, String> insertDbyID(@RequestBody Map<String, Object> param){
    	
		HashMap<String, String> res=new HashMap();
		String uid = (String)param.get("uid");
		//ArrayList<Integer> did_li = new ArrayList<Integer>();
		ArrayList<String> did_li = new ArrayList<String>();
		did_li = (ArrayList<String>) param.get("did");
		//did_li.add(Integer.parseInt((String) param.get("did")));
		for(int i=0;i<did_li.size();i++) {
			try {
				hdao.insertDbyID(uid, Integer.parseInt(did_li.get(i)));
			}catch(Exception ex) {
				res.put("status", "1062");//以묐났肄붾뱶
				res.put("Exception", ex.getMessage());
				return res;
			}
		}
		
		res.put("status", "OK");
		return res;
    }
    
    @ResponseBody
    @RequestMapping(value = "/Disease/deleteDisease", method = RequestMethod.POST)
    public HashMap<String, String> deleteDisease(@RequestBody Map<String, String> param){
    	
		HashMap<String, String> res=new HashMap();
		String uid = (String)param.get("uid");
		String dname = (String) param.get("dname");
		try {
			dao.deleteDisease(uid, dname);
		}catch(Exception ex) {
			res.put("status", "1062");//以묐났肄붾뱶
			res.put("Exception", ex.getMessage());
			return res;
		}
		
		res.put("status", "OK");
		return res;
    }
    
    
    
}
