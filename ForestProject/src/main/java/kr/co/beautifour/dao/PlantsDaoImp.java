package kr.co.beautifour.dao;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import kr.co.beautifour.domain.PlantsVO;
import org.springframework.stereotype.Repository;


@Repository //DAO��� ��� (DAO�� ���������� �νĽ�����)
public class PlantsDaoImp implements PlantsDao {

    @Inject // �������踦 �ڵ����� ����(JAVA���� ����) ==@autowired (Spring���� ����)
    private SqlSession sqlSession;
   
    private static final String namespace = "kr.co.beautifour.PlantsMapper";
   
    @Override
    public List<PlantsVO> selectPlants(PlantsVO vo) {
        return sqlSession.selectList(namespace+".selectPlants", vo);
    }
    
    @Override
    public List<PlantsVO> selectsearchPlants(String search) {
    	return sqlSession.selectList(namespace+".selectsearchPlants", search);
    }
   
}

