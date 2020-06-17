package kr.co.beautifour.web;

import javax.inject.Inject;

import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class TestDao {
   
    @Inject
    private PlantsDao dao;
   
    @ResponseBody
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public List<PlantsVO> testDAO(){
        PlantsVO vo = new PlantsVO();
         List<PlantsVO> result =  dao.selectPlants(vo);    
        return result;
    }
}
