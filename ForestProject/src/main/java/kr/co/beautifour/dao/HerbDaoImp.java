package kr.co.beautifour.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.DiseaseVO;

@Repository //DAO��� ��� (DAO�� ���������� �νĽ�����)
public class HerbDaoImp implements HerbDao{
	
	 @Inject // �������踦 �ڵ����� ����(JAVA���� ����) ==@autowired (Spring���� ����)
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
	
	@Override
	public List<DiseaseVO> selectDisease(String search) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectDisease", search);
	}


}
