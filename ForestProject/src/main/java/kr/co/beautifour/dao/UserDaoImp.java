package kr.co.beautifour.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import kr.co.beautifour.domain.MybookVO;
import kr.co.beautifour.domain.UserVO;

@Repository
public class UserDaoImp implements UserDao{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace ="kr.co.beautifour.UserMapper";
	
	@Override
	public List<UserVO> selectUser(UserVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectUser",vo);
	}

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


	
}
