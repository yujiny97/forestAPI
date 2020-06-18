package kr.co.beautifour.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;

@Repository //DAO라고 명시 (DAO를 스프링에서 인식시켜줌)
public class HerbDaoImp implements HerbDao{
	
	 @Inject // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
	 private SqlSession sqlSession;
	 
	private static final String namespace = "kr.co.beautifour.PlantsMapper";
	   
	@Override
	public List<HerbVO> selectHerbs(HerbVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectHerbs", vo);
	}

	@Override
	public List<HerbContVO> selectHerbsCountry(HerbContVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectHerbsCountry", vo);
	}


}
