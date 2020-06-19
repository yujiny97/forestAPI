package kr.co.beautifour.web;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.beautifour.dao.UserDao;
import kr.co.beautifour.domain.MybookVO;
import kr.co.beautifour.domain.UserVO;

@Controller
public class UserController {

	@Inject
	private UserDao dao;
	
	//모든 유저정보 가져오기
	@ResponseBody
	@RequestMapping(value="/getAllUser",method= RequestMethod.GET)
	public List<UserVO> getallUser(){
		UserVO vo=new UserVO();
		List<UserVO> res=dao.selectUser(vo);
		return res;
	}
	
	//유저정보 insert하기
	@ResponseBody
	@RequestMapping(value="/User/InsertUser",method=RequestMethod.POST)
	public Map<String, String> insertUser(@RequestBody Map<String, Object> param) {
		UserVO vo=new UserVO(
				(String)param.get("uid"),
				(String)param.get("pw"),
				(String)param.get("uname"),
				(String)param.get("gender"),
				((Integer)param.get("age")).intValue()
				);
		Map<String, String> res=new HashMap();
		
		try {
			dao.insertUser(vo);
		}catch(Exception ex) {
			res.put("status", "1062");//중복코드
			return res;
		}
		res.put("status", "OK");
		return res;
	}
//도감 추가하기
	@ResponseBody
	@RequestMapping(value="/Mybook/Insertbook",method=RequestMethod.POST)
	public Map<String,String> insertMybook(@RequestBody Map<String,Object> p){
		System.out.println("Controller start");
		MybookVO vo=new MybookVO(
				(String)p.get("uid"),
				(String)p.get("story"),
				(String)p.get("pic"),
				(String)p.get("forT")
				);
		System.out.println("Controller");
		Map<String, String> res=new HashMap();
		
		try {
			dao.insertMybook(vo);
		}catch(Exception ex) {
			System.out.println(ex);
			System.out.println("Controller Exception");
			res.put("status", "1062");//중복코드
			return res;
		}
		System.out.println("Controller finished");
		res.put("status", "OK");
		return res;
	}
}
