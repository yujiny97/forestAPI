package kr.co.beautifour.dao;

import java.util.List;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.SelectHerbByDiseaseVO;
import kr.co.beautifour.domain.TherapyVO;
import kr.co.beautifour.domain.AllHerbVO;
import kr.co.beautifour.domain.DiseaseVO;
import kr.co.beautifour.domain.UserHerbVO;

public interface HerbDao {
	
	public List<AllHerbVO> selectAllHerb();
	public HerbVO selectHerbs(int no);
	public List<TherapyVO> selectTherapy(int no);
	public List<HerbContVO> selectHerbsCountry(int no);
	public List<DiseaseVO> selectDisease(String search);
	public List<SelectHerbByDiseaseVO> selectHerbsbyDisease(String search);
	public List<UserHerbVO> selectUserHerb(String UID);
	
}
