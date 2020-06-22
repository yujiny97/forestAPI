package kr.co.beautifour.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.SelectHerbByDiseaseVO;
import kr.co.beautifour.domain.TherapyVO;
import kr.co.beautifour.domain.AllHerbVO;
import kr.co.beautifour.domain.DiseaseVO;

public interface HerbDao {
	
	public List<AllHerbVO> selectAllHerb();
	public HerbVO selectHerbs(int no);
	public List<TherapyVO> selectTherapy(int no);
	public List<HerbContVO> selectHerbsCountry(int no);
	public List<DiseaseVO> selectDisease(String search);
	public List<SelectHerbByDiseaseVO> selectHerbsbyDisease(String search);
	public void insertDbyID(String uid, int did) throws Exception;
	
}
