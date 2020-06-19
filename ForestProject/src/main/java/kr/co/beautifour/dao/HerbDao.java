package kr.co.beautifour.dao;

import java.util.List;

import kr.co.beautifour.domain.HerbContVO;
import kr.co.beautifour.domain.HerbVO;
import kr.co.beautifour.domain.DiseaseVO;

public interface HerbDao {
	public List<HerbVO> selectHerbs(HerbVO vo);
	public List<HerbContVO> selectHerbsCountry(HerbContVO vo1);
	public List<DiseaseVO> selectDisease(String search);
}
