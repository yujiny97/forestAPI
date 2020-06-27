package kr.co.beautifour.dao;

import java.util.List;

import kr.co.beautifour.domain.MybookVO;
import kr.co.beautifour.domain.TempPlantsVO;
import kr.co.beautifour.domain.UserVO;

public interface UserDao {
	public List<UserVO> selectUser(UserVO vo)throws Exception;
	public List<UserVO> selectUserByID(UserVO vo)throws Exception;
	public int UserValid(UserVO vo)throws Exception;
	public void insertUser(UserVO vo) throws Exception;
	public void insertMybook(MybookVO vo) throws Exception;
	public List<MybookVO> selectMybook(MybookVO vo) throws Exception;
	public void deleteMybookbyID(MybookVO vo) throws Exception;
	public void updateMybookbyID(MybookVO vo) throws Exception;
	public void insertTempPlants(TempPlantsVO vo) throws Exception;
	public void updateTempPlants(TempPlantsVO vo) throws Exception;
	public List<TempPlantsVO> selectTempPlants(TempPlantsVO vo) throws Exception;
	public TempPlantsVO selectoneTempPlants(TempPlantsVO vo) throws Exception;
	public void deleteTempPlantsByID(TempPlantsVO vo) throws Exception;
	public void deleteAllTempPlants(TempPlantsVO vo) throws Exception;
	public int selectonePlants(TempPlantsVO vo) throws Exception;
}
