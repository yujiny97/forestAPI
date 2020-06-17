package kr.co.beautifour.web;

import javax.inject.Inject;

import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class TestDao {
   
    @Inject
    private PlantsDao dao;
   
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public String testDAO(){
        PlantsVO vo = new PlantsVO();
        List<PlantsVO> result =  dao.selectPlants(vo);
        for(int i=0;i<result.size();i++) {
        	System.out.println(result.get(i).getpNum()+"번째, "+result.get(i).getfskName());
        }
        return "testDAO";
    }
}
