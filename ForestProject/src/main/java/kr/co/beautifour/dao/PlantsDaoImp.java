package kr.co.beautifour.dao;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Repository;


@Repository //DAO라고 명시 (DAO를 스프링에서 인식시켜줌)
public class PlantsDaoImp implements PlantsDao {

    @Inject // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
    private SqlSession sqlSession;
   
    private static final String namespace = "kr.co.beautifour.PlantsMapper";
   
    @Override
    public List<PlantsVO> selectPlants(PlantsVO vo) {
        return sqlSession.selectList(namespace+".selectPlants", vo);
		
    }
   
}

