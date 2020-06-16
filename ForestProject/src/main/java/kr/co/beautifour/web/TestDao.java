package kr.co.beautifour.web;

import javax.inject.Inject;

import kr.co.beautifour.dao.PlantsDao;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestDao {
   
    @Inject
    private PlantsDao dao;
   
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public void testDAO(){
        PlantsVO vo = new PlantsVO();
        
        System.out.println(dao.selectPlants(vo).toString());
    }
}
