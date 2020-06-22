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
    public List<PlantsVO> getPlants(HttpServletRequest request){
    	int no=0;
    	//���� �Ѱܹ��� ���� �ִٸ�
    	if(request.getParameter("pNum")!=null) {
    		no = Integer.parseInt(request.getParameter("pNum"));
    	}
    	
         List<PlantsVO> result =  dao.selectPlants(no);    
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
    @RequestMapping(value = "/PlantInfo/getPlantsbyName", method = RequestMethod.GET)
    public List<PlantsVO> getPlantsbyName(HttpServletRequest request){
        
        String search = request.getParameter("search");
         List<PlantsVO> result =  dao.selectsearchPlants(search);
         
        return result;
    }
    
    //���� ��� �����ֱ�
    @ResponseBody
    @RequestMapping(value = "/Disease/getDList", method = RequestMethod.GET)
    public List<DiseaseVO> getDList(HttpServletRequest request){
        String search = request.getParameter("search");
    	List<DiseaseVO> result =  hdao.selectDisease(search);
        return result;
    }
    
    //���̸����� �ش��ϴ� �Ĺ� ��������
    @ResponseBody
    @RequestMapping(value = "/PlantInfo/getPlantsbyDisease", method = RequestMethod.GET)
    public List<SelectHerbByDiseaseVO> getPlantsbyDisease(HttpServletRequest request){
    	String search = request.getParameter("search");
    	List<SelectHerbByDiseaseVO> result =  hdao.selectHerbsbyDisease(search);
        return result;
    }
    
    //���̸����� �ش��ϴ� �Ĺ� ��������
    @ResponseBody
    @RequestMapping(value = "/Disease/insertDbyID", method = RequestMethod.POST)
    public HashMap<String, String> insertDbyID(@RequestBody Map<String, Object> param){
    	
		HashMap<String, String> res=new HashMap();
		String uid = (String)param.get("uid");
		//ArrayList<Integer> did_li = new ArrayList<Integer>();
		ArrayList<String> did_li = new ArrayList<String>();
		did_li = param.get("did");
		//did_li.add(Integer.parseInt((String) param.get("did")));
		for(int i=0;i<did_li.size();i++) {
			try {
				hdao.insertDbyID(uid, did_li.get(i));
			}catch(Exception ex) {
				res.put("status", "1062");//중복코드
				res.put("Exception", ex.getMessage());
				return res;
			}
		}
		
		res.put("status", "OK");
		return res;
    }
    
}
