package kr.co.beautifour.web;

import javax.inject.Inject;


import kr.co.beautifour.dao.HerbDao;
import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.PlantsVO;
import kr.co.beautifour.domain.SelectHerbByDiseaseVO;
import kr.co.beautifour.domain.TherapyVO;
import kr.co.beautifour.domain.AllHerbVO;
import kr.co.beautifour.domain.DiseaseVO;
import kr.co.beautifour.domain.UserHerbVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlantsController {
   
    @Inject
    private PlantsDao dao;
    
    @Inject
    private HerbDao hdao;
    
    //��ü ������� �����ֱ�
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllPlants", method = RequestMethod.GET)
    public List<PlantsVO> getAllPlants(){
    	List<PlantsVO> result =  dao.selectAllPlants();    
        return result;
    }
    
    //�Ѱ��� �Ĺ����� �����ֱ� - pNum���� ����
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getPlants", method = RequestMethod.GET)
    public List<PlantsVO> getPlants(){   	
         List<PlantsVO> result =  dao.selectAllPlantsInfo();    
        return result;
    }
    
    //��ü ��굵����� �����ֱ�
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getAllHerb", method = RequestMethod.GET)
    public List<AllHerbVO> getAllHerb(){
    	List<AllHerbVO> result =  hdao.selectAllHerb();    
        return result;
    }
    
    //�Ѱ��� ������� �����ֱ� - HrbId�� ����
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getHerbs", method = RequestMethod.GET)
    public HerbVO getHerbs(HttpServletRequest request){
        int no=0;
    	//���� �Ѱܹ��� ���� �ִٸ�
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
    
    //�̸����� �Ĺ� �˻��ϱ�
    @ResponseBody
    @RequestMapping(value = "/getPlantsbyName", method = RequestMethod.GET)
    public List<PlantsVO> getPlantsbyName(HttpServletRequest request){
        
        String search = request.getParameter("search");
         List<PlantsVO> result =  dao.selectsearchPlants(search);
         
        return result;
    }
    
    //���� ��� �����ֱ�
    @ResponseBody
    @RequestMapping(value = "/getDList", method = RequestMethod.GET)
    public List<DiseaseVO> getDList(HttpServletRequest request){
        String search = request.getParameter("search");
    	List<DiseaseVO> result =  hdao.selectDisease(search);
        return result;
    }
    
    //���̸����� �ش��ϴ� �Ĺ� ��������
    @ResponseBody
    @RequestMapping(value = "/getPlantsbyDisease", method = RequestMethod.GET)
    public List<SelectHerbByDiseaseVO> getPlantsbyDisease(HttpServletRequest request){
    	String search = request.getParameter("search");
    	List<SelectHerbByDiseaseVO> result =  hdao.selectHerbsbyDisease(search);
        return result;
    }
    
  //���̸����� �ش��ϴ� �Ĺ� ��������
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
		}catch(Exception ex) {//에러가 발생할 경우
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", result);
		return res;
    }
    
}
