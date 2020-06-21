package kr.co.beautifour.dao;

import java.util.List;

import kr.co.beautifour.domain.PlantsVO;

public interface PlantsDao {
	public List<PlantsVO> selectPlants(int no);
	public List<PlantsVO> selectAllPlants();
	public List<PlantsVO> selectsearchPlants(String search);
}
