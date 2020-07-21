package kr.co.beautifour.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Repository;


@Repository //DAO占쏙옙占� 占쏙옙占� (DAO占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싸식쏙옙占쏙옙占쏙옙)
public class PlantsDaoImp implements PlantsDao {

    @Inject // 占쏙옙占쏙옙占쏙옙占썼를 占쌘듸옙占쏙옙占쏙옙 占쏙옙占쏙옙(JAVA占쏙옙占쏙옙 占쏙옙占쏙옙) ==@autowired (Spring占쏙옙占쏙옙 占쏙옙占쏙옙)
    private SqlSession sqlSession;
   
    private static final String namespace = "kr.co.beautifour.PlantsMapper";
   
    @Override
    public List<PlantsVO> selectAllPlantsInfo() {
        return sqlSession.selectList(namespace+".selectAllPlantsInfo");
    }
    
    @Override
    public List<PlantsVO> selectPlants(int no) {
        return sqlSession.selectList(namespace+".selectPlants", no);
    }
    
    @Override
    public List<PlantsVO> selectAllPlants() {
        return sqlSession.selectList(namespace+".selectAllPlants");
    }
    
    @Override
    public List<PlantsVO> selectsearchPlants(String search) {
    	return sqlSession.selectList(namespace+".selectsearchPlants", search);
    }
    
    @Override
    public void deleteDisease(String uid, String dname) throws Exception{
    	HashMap<String, String> user = new HashMap<String, String>();
		user.put("UID", uid);
		user.put("DName", dname);
		sqlSession.selectList(namespace+".deleteDisease", user);
    }
    
    @Override
    public List<PlantsVO> selectAllPlantsByMok(){
        return sqlSession.selectList(namespace+".selectAllPlantsByMok");
    }
    
    @Override
    public List<PlantsVO> selectAllPlantsByCho(){
        return sqlSession.selectList(namespace+".selectAllPlantsByCho");
    }
   
}

