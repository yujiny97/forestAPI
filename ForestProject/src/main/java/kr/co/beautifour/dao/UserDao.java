package kr.co.beautifour.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.beautifour.domain.MybookVO;
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
}
