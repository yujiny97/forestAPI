package kr.co.beautifour.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.beautifour.domain.UserVO;

public interface UserDao {
	public List<UserVO> selectUser(UserVO vo);
	public void insertUser(UserVO vo) throws Exception;
}
