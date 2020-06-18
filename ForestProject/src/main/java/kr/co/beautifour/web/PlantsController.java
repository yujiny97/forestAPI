package kr.co.beautifour.web;

import javax.inject.Inject;

import kr.co.beautifour.dao.HerbDao;
import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class PlantsController {
   
    @Inject
    private PlantsDao dao;
   
    @ResponseBody
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public List<PlantsVO> testDAO(){
        PlantsVO vo = new PlantsVO();
         List<PlantsVO> result =  dao.selectPlants(vo);    
        return result;
    }
    
    @Inject
    private HerbDao hdao;
   
    @ResponseBody
    @RequestMapping(value = "/herbDAO", method = RequestMethod.GET)
    public List<HerbVO> herbDAO(){
        HerbVO vo = new HerbVO();
         List<HerbVO> result =  hdao.selectHerbs(vo);
         HerbContVO vo1 = new HerbContVO();
         List<HerbContVO> result1 = hdao.selectHerbsCountry(vo1);
         for(int i=0;i<result.size();i++) {
        	 for(int j=0;j<result1.size();j++) {
        		 if(result.get(i).getHrbId()==result1.get(j).getHrbId()) {
        			 result.get(i).setcountry(result1.get(j).getCountry());
        		 }
        		 else {
        			 if(result.get(i).getHrbId()<result1.get(j).getHrbId()) break;
        			 else continue;
        		 }
        	 }
        	 
        }
        return result;
    }
}
