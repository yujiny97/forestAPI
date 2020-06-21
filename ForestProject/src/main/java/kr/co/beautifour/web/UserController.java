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
	public Map<String,Object> getallUser(){
		UserVO vo=new UserVO();
		List<UserVO> user=null;
		Map<String, Object> res=new HashMap();
		try {
		user=dao.selectUser(vo);
		}catch(Exception ex) {//에러가 발생할 경우
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", user);
		return res;
	}
	
	//유저정보 ID로 가져오기
	@ResponseBody
	@RequestMapping(value="/User/getUserByID",method= RequestMethod.POST)
	public Map<String,Object> getUserByID(@RequestBody Map<String, Object> param){
		System.out.println("Controller까지 됨");
		UserVO vo=new UserVO();
		vo.setUID((String)(param.get("uid")));
		List<UserVO> user=null;
		Map<String, Object> res=new HashMap();
		try {
		user=dao.selectUserByID(vo);
		}catch(Exception ex) {//에러가 발생할 경우
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", user);
		return res;
	}
	
	//유저정보 ID로 가져오기
	@ResponseBody
	@RequestMapping(value="/User/UserValid",method= RequestMethod.POST)
	public Map<String,Object> Uservalid(@RequestBody Map<String, Object> param){
		System.out.println("Controller까지 됨");
		UserVO vo=new UserVO();
		vo.setUID((String)(param.get("uid")));
		vo.setPW((String)(param.get("pw")));
		int valid=0;
		Map<String, Object> res=new HashMap();
		try {
		valid=dao.UserValid(vo);
		}catch(Exception ex) {//에러가 발생할 경우
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", valid);//cnt 확인
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
			res.put("Exception", ex.getMessage());
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
			res.put("status", "1062");//중복코드
			res.put("Exception", ex.getMessage());
			return res;
		}
		System.out.println("Controller finished");
		res.put("status", "OK");
		return res;
	}
	//도감리스트
		@ResponseBody
		@RequestMapping(value="/Mybook/getMybooklist",method=RequestMethod.POST)
		public Map<String,Object> getMybooklist(@RequestBody Map<String,Object> p){
			System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setUid((String)p.get("uid"));
			System.out.println("Controller");
			Map<String, Object> res=new HashMap();
			List<MybookVO> mybook=null;
			try {
				mybook=dao.selectMybook(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//중복코드
				res.put("Exception", ex.getMessage());
				return res;
			}
			System.out.println("Controller finished");
			res.put("data", mybook);
			res.put("status", "OK");
			
			return res;
		}
		//도감 삭제하기
		@ResponseBody
		@RequestMapping(value="/Mybook/deleteMybookbyID",method=RequestMethod.DELETE)
		public Map<String,String> deleteMybookbyID(@RequestBody Map<String,Object> p){
			System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setBookid(((Integer)p.get("bookid")).intValue());
			vo.setUid((String)p.get("uid"));
			System.out.println("Controller");
			Map<String, String> res=new HashMap();
			try {
				dao.deleteMybookbyID(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		
		//도감 수정하기
		@ResponseBody
		@RequestMapping(value="/Mybook/UpdatebookbyID",method=RequestMethod.PUT)
		public Map<String,String> updateMybookbyID(@RequestBody Map<String,Object> p){
			System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setBookid(((Integer)p.get("bookid")).intValue());
			vo.setUid((String)p.get("uid"));
			vo.setUid((String)p.get("story"));
			vo.setUid((String)p.get("picadd"));
			System.out.println("Controller");
			Map<String, String> res=new HashMap();
			try {
				dao.updateMybookbyID(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
}
