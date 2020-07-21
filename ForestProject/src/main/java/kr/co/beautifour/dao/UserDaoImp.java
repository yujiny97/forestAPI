package kr.co.beautifour.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.beautifour.domain.MybookVO;
import kr.co.beautifour.domain.TempPlantsVO;
import kr.co.beautifour.domain.UserVO;

@Repository
public class UserDaoImp implements UserDao{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="kr.co.beautifour.UserMapper";


	@Override
	public void insertUser(UserVO vo) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("insertUser OK");
		sqlSession.insert(namespace+".insertUser", vo);
	}

	@Override
	public void insertMybook(MybookVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insertMybook OK");
		sqlSession.insert(namespace+".insertMybook", vo);
	}

	@Override
	public List<UserVO> selectUserByID(UserVO vo) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("selectUserBYID까지 됨");
		return sqlSession.selectList(namespace+".selectUserByID",vo);
	}

	@Override
	public List<MybookVO> selectMybook(MybookVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("selectMybookBYID까지 됨");
		return sqlSession.selectList(namespace+".selectMybookByID",vo);
		
	}

	@Override
	public void deleteMybookbyID(MybookVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("deleteMybookBYID까지 됨");
		sqlSession.delete(namespace+".deleteMybookByID",vo);
		
	}
	
	@Override
	public void updateMybookbyID(MybookVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("updateMybookBYID까지 됨");
		sqlSession.update(namespace+".updateMybookByID",vo);
		
	}

	@Override
	public int UserValid(UserVO vo) throws Exception {
		System.out.println("Uservalid sql 실행전");
		return sqlSession.selectOne(namespace+".Uservalid", vo);
	}
	
	@Override
	public void insertTempPlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insertTempPlants OK");
		sqlSession.insert(namespace+".insertTempPlants", vo);
	}
	
	@Override
	public void updateTempPlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("updateTempPlants까지 됨");
		sqlSession.update(namespace+".updateTempPlants",vo);
		
	}
	
	@Override
	public List<TempPlantsVO> selectTempPlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("selectTempPlantsVO까지 됨");
		return sqlSession.selectList(namespace+".selectTempPlants",vo);
		
	}
	@Override
	public TempPlantsVO selectoneTempPlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("selectTempPlantsVO까지 됨");
		return sqlSession.selectOne(namespace+".selectOneTempPlants",vo);
		
	}
	
	@Override
	public void deleteTempPlantsByID(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("deleteTempPlantsVO까지 됨");
		sqlSession.delete(namespace+".deleteTempPlants",vo);
		
	}
	
	@Override
	public void deleteAllTempPlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("deleteallTempPlantsVO까지 됨");
		sqlSession.delete(namespace+".deleteallTempPlants",vo);
		
	}
	
	@Override
	public int selectonePlants(TempPlantsVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("count Plants");
		return sqlSession.selectOne(namespace+".selectOnePlantsByName",vo);
		
	}
	
	//게시판에서 공개인 애들은 다 가져온다.
	@Override
	public List<TempPlantsVO> selectALLTempPlants() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("selectALLTempPlants까지 됨");
		return sqlSession.selectList(namespace+".selectALLTempPlants");
		
	}


	
}
