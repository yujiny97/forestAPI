package kr.co.beautifour.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.SelectHerbByDiseaseVO;
import kr.co.beautifour.domain.TherapyVO;
import kr.co.beautifour.domain.AllHerbVO;
import kr.co.beautifour.domain.DiseaseVO;
import kr.co.beautifour.domain.UserHerbVO;


@Repository //DAO占쏙옙占� 占쏙옙占� (DAO占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싸식쏙옙占쏙옙占쏙옙)
public class HerbDaoImp implements HerbDao{
	
	 @Inject // 占쏙옙占쏙옙占쏙옙占썼를 占쌘듸옙占쏙옙占쏙옙 占쏙옙占쏙옙(JAVA占쏙옙占쏙옙 占쏙옙占쏙옙) ==@autowired (Spring占쏙옙占쏙옙 占쏙옙占쏙옙)
	 private SqlSession sqlSession;
	 
	private static final String namespace = "kr.co.beautifour.PlantsMapper";
	
	@Override
	public List<AllHerbVO> selectAllHerb() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectAllHerb");
	}
	
	@Override
	public HerbVO selectHerbs(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectHerbs", no);
	}

	@Override
	public List<HerbContVO> selectHerbsCountry(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectHerbsCountry", no);
	}
	
	@Override
	public List<TherapyVO> selectTherapy(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectTherapy", no);
	}
	
	@Override
	public List<DiseaseVO> selectDisease(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectDisease", search);
	}
	
	@Override
	public List<SelectHerbByDiseaseVO> selectHerbsbyDisease(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectHerbsbyDisease", search);
	}
	
	@Override
	public void insertDbyID(String uid, int did) throws Exception{
		// TODO Auto-generated method stub
		HashMap<String, Object> user = new HashMap<String, Object>();
		user.put("uid", uid);
		user.put("did", did);
		sqlSession.selectList(namespace+".insertDbyID", user);
	}
	
	@Override
    public List<UserHerbVO> selectUserHerb(String UID) {
       return sqlSession.selectList(namespace+".selectUserHerb", UID);
    }


}
