package kr.co.beautifour.dao;

import java.util.List;

import kr.co.beautifour.domain.PlantsVO;

public interface PlantsDao {
	public List<PlantsVO> selectPlants(int no);
	public List<PlantsVO> selectAllPlants();
	public List<PlantsVO> selectAllPlantsInfo();
	public List<PlantsVO> selectsearchPlants(String search);
	public void deleteDisease(String uid, String dname) throws Exception;
	public List<PlantsVO> selectAllPlantsByMok();
	public List<PlantsVO> selectAllPlantsByCho();
}
