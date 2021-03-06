package kr.co.beautifour.web;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import kr.co.beautifour.dao.UserDao;
import kr.co.beautifour.domain.CommentVO;
import kr.co.beautifour.domain.MybookVO;
import kr.co.beautifour.domain.TempPlantsVO;
import kr.co.beautifour.domain.UserVO;

@Controller
public class UserController {

	@Inject
	private UserDao dao;
	
	 @Autowired
	 ServletContext context;
	//private String url="52.14.219.87";
	
	//유저정보 ID로 가져오기
	@ResponseBody
	@RequestMapping(value="/User/getUserByID",method= RequestMethod.POST)
	public Map<String,Object> getUserByID(@RequestBody Map<String, Object> param){
		////System.out.println("Controller까지 됨");
		UserVO vo=new UserVO();
		vo.setUID((String)(param.get("uid")));
		List<UserVO> user=null;
		Map<String, Object> res=new HashMap();
		try {
		user=dao.selectUserByID(vo);
		user.get(0).setPW("****");//비밀번호는 보이지 않도록 하기
		}catch(Exception ex) {//에러가 발생할 경우
			res.put("status", "not OK");
			res.put("message",ex.getMessage());
			return res;
		}
		res.put("status", "OK");
		res.put("data", user);
		return res;
	}
	
	//유저정보 Valid한지 확인하기
	@ResponseBody
	@RequestMapping(value="/User/UserValid",method= RequestMethod.POST)
	public Map<String,Object> Uservalid(@RequestBody Map<String, Object> param){
		////System.out.println("Controller까지 됨");
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
		////System.out.println("Controller start");
		MybookVO vo=new MybookVO(
				(String)p.get("uid"),
				(String)p.get("story"),
				(String)p.get("pic"),
				(String)p.get("forT")
				);
		////System.out.println("Controller");
		Map<String, String> res=new HashMap();
		
		try {
			dao.insertMybook(vo);
		}catch(Exception ex) {
			System.out.println(ex);
			res.put("status", "1062");//중복코드
			res.put("Exception", ex.getMessage());
			return res;
		}
		////System.out.println("Controller finished");
		res.put("status", "OK");
		return res;
	}
	//도감리스트
		@ResponseBody
		@RequestMapping(value="/Mybook/getMybooklist",method=RequestMethod.POST)
		public Map<String,Object> getMybooklist(@RequestBody Map<String,Object> p){
			////System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setUid((String)p.get("uid"));
			////System.out.println("Controller");
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
			////System.out.println("Controller finished");
			res.put("data", mybook);
			res.put("status", "OK");
			
			return res;
		}
		//도감 삭제하기
		@ResponseBody
		@RequestMapping(value="/Mybook/deleteMybookbyID",method=RequestMethod.DELETE)
		public Map<String,String> deleteMybookbyID(@RequestBody Map<String,Object> p){
			////System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setBookid(((Integer)p.get("bookid")).intValue());
			vo.setUid((String)p.get("uid"));
			////System.out.println("Controller");
			Map<String, String> res=new HashMap();
			try {
				dao.deleteMybookbyID(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		
		//도감 수정하기
		@ResponseBody
		@RequestMapping(value="/Mybook/UpdatebookbyID",method=RequestMethod.PUT)
		public Map<String,String> updateMybookbyID(@RequestBody Map<String,Object> p){
			////System.out.println("Controller start");
			MybookVO vo=new MybookVO();
			vo.setBookid(((Integer)p.get("bookid")).intValue());
			vo.setUid((String)p.get("uid"));
			vo.setUid((String)p.get("story"));
			vo.setUid((String)p.get("picadd"));
			////System.out.println("Controller");
			Map<String, String> res=new HashMap();
			try {
				dao.updateMybookbyID(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		//////////////////insert tempPlants
		String filePath="/home/centos/resource/img/";//centos에서 저장해야하는 장소
		String savePath="http://52.14.219.87:8080/Img/Plants/";
		
		  //String filePath="C:/spring_workspace/imagetest/"; 
		  //String savePath="http://localhost:8080/Test/";
		 
		
		//도감 추가하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/InsertTempPlants",method=RequestMethod.POST)
		public Map<String,String> insertTempPlants(
				//@RequestPart(required=true) , 
				@RequestParam(name = "uid", required = true) String uid,
				@RequestParam(name = "fskName", required = true) String fskName,
				@RequestParam(name = "fseName") String fseName,
				@RequestParam(name = "fsLifeTime") String fsLifeTime,
				@RequestParam(name = "fsGbn") String fsGbn,
				@RequestParam(name = "fsClassname") String fsClassname,
				@RequestParam(name = "isHerb") Integer isHerb,
				@RequestParam(name = "isPV", required=false) Integer isPV,
				@RequestPart(value="file", required = true) final MultipartFile images)throws Exception{
			////System.out.println("Controller start");
			Map<String, String> res=new HashMap();
			
			//파일을 먼저 경로에 저장한다.
			String orgFile=images.getOriginalFilename();
			String orgFileExtension=orgFile.substring(orgFile.lastIndexOf("."));//확장자 가져오기
	        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
	        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
	        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성  
			String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
			File file = new File(filePath + storedFileName);
			//저장 경로를 vo의 파일 이름으로 넣는다.
			////System.out.println("Controller");
			
			try {
				images.transferTo(file);
			} catch (IllegalStateException e) {
				System.out.println(e);
				res.put("status", "IllegalStateException");//중복코드
				res.put("Exception", e.getMessage());
				return res;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				res.put("status", "IOException");//중복코드
				res.put("Exception", e.getMessage());
				return res;
			}
		
			TempPlantsVO vo=new TempPlantsVO(
					uid,
					fskName,
					fseName,
					fsLifeTime,
					savePath + storedFileName,
					fsGbn,
					fsClassname,
					isHerb.intValue()
					);
			////System.out.println(isPV);
			if(isPV!=null) {
				vo.setIsPV(isPV);
			}else {
				vo.setIsPV(1);//default는 1
			}
			try {
				dao.insertTempPlants(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//중복코드
				res.put("Exception", ex.getMessage());
				return res;
			}
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		
		///////////select tempPlants
		//////////////////update tempPlants
		//도감 추가하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/UpdateTempPlants",method=RequestMethod.POST)
		public Map<String,String> updateTempPlants(
				@RequestParam(name = "bid", required = true) Integer bid, 
				@RequestParam(name = "uid", required = true) String uid,
				@RequestParam(name = "fskName", required = true) String fskName,
				@RequestParam(name = "fseName") String fseName,
				@RequestParam(name = "fsLifeTime") String fsLifeTime,
				@RequestParam(name = "fsGbn") String fsGbn,
				@RequestParam(name = "fsClassname") String fsClassname,
				@RequestParam(name = "isHerb") Integer isHerb,
				@RequestParam(name = "changedpic") Integer changedpic,//1이면 바뀐거고 0이면 안바뀐것
				@RequestParam(name = "isPV", required = false) Integer isPV,//isPV가 오지 않는다면 처리해야함
				@RequestPart(value="file", required = true) final MultipartFile images)throws Exception{
			////System.out.println("Controller start");
			Map<String, String> res=new HashMap();
			TempPlantsVO vo=new TempPlantsVO();
			vo.setUid(uid);
			vo.setBid(bid.intValue());
			vo.setFsLifeTime(fsLifeTime);
			vo.setFsClassname(fsClassname);
			vo.setFseName(fseName);
			vo.setFsGbn(fsGbn);
			vo.setFskName(fskName);
			vo.setIsHerb(isHerb);
			if(isPV!=null) {
				vo.setIsPV(isPV);
			}else {
				vo.setIsPV(1);//default는 1
			}
			
			
			TempPlantsVO old=dao.selectoneTempPlants(vo);
			String fname=old.getFsImg_1();
			String orgFileExtension=fname.substring(fname.lastIndexOf("."));//확장자 가져오기
			String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
			////System.out.println("file name:"+ storedFileName);
			
			
			String[] lst=fname.split("/");
			fname=savePath+lst[lst.length-1];//이름은 이전꺼랑 똑같이 가져오기
			File file = new File(filePath+lst[lst.length-1]);
			////System.out.println(filePath+lst[lst.length-1]);
			file.delete();
			//savePath+storedFileName
			vo.setFsImg_1(savePath+storedFileName);
			
			if(changedpic.intValue()==1)// 바뀐경우 사진 새롭게 추가
			{
				File file2 = new File(filePath+storedFileName);	
				try {
					images.transferTo(file2);
				} catch (IllegalStateException e) {
					System.out.println(e);
					res.put("status", "IllegalStateException");//중복코드
					res.put("Exception", e.getMessage());
					return res;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					res.put("status", "IOException");//중복코드
					res.put("Exception", e.getMessage());
					return res;
				}
			}
			try {
				dao.updateTempPlants(vo);
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//중복코드
				res.put("Exception", ex.getMessage());
				return res;
			}
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		
		//UID로 TPlants 가져오기
		@ResponseBody
		@RequestMapping(value="/TempPlants/getTempPlants",method= RequestMethod.POST)
		public Map<String,Object> getTempPlants(@RequestBody Map<String, Object> param){
			////System.out.println("select TempPlants Controller까지 됨");
			TempPlantsVO vo=new TempPlantsVO();
			vo.setUid((String)param.get("uid"));
			List<TempPlantsVO> TPlants=null;
			Map<String, Object> res=new HashMap();
			try {
			TPlants=dao.selectTempPlants(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			res.put("data", TPlants);
			return res;
		}
		
		//게시판의 모든 Plants들을 가져오기
		@ResponseBody
		@RequestMapping(value="/TempPlants/getALLTempPlants",method= RequestMethod.GET)
		public Map<String,Object> getALLTempPlants(){
			////System.out.println("select TempPlants Controller까지 됨");
			List<TempPlantsVO> TPlants=null;
			Map<String, Object> res=new HashMap();
			try {
			TPlants=dao.selectALLTempPlants();
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			res.put("data", TPlants);
			return res;
		}
		
		//UID로 TPlants 가져오기
		@ResponseBody
		@RequestMapping(value="/TempPlants/getoneTempPlants",method= RequestMethod.POST)
		public Map<String,Object> getOneTempPlants(@RequestBody Map<String, Object> param){
			////System.out.println("select TempPlants Controller까지 됨");
			TempPlantsVO vo=new TempPlantsVO();
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			TempPlantsVO TPlants=null;
			Map<String, Object> res=new HashMap();
			try {
			TPlants=dao.selectoneTempPlants(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			res.put("data", TPlants);
			return res;
		}
		
		//UID와 BID로 도감 삭제하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/deleteTempPlants",method=RequestMethod.DELETE)
		public Map<String,String> deleteTempPlantsByID(@RequestBody Map<String,Object> p){
			////System.out.println("Controller start");
			TempPlantsVO vo=new TempPlantsVO();
			vo.setBid(((Integer)p.get("bid")).intValue());
			vo.setUid((String)p.get("uid"));
			////System.out.println("Controller");
			CommentVO vo2=new CommentVO();
			vo2.setUid(vo.getUid());
			vo2.setBid(vo.getBid());
			Map<String, String> res=new HashMap();
			try {
				TempPlantsVO old=dao.selectoneTempPlants(vo);
				String fname=old.getFsImg_1();
				String[] lst=fname.split("/");
				fname=filePath+lst[lst.length-1];
				File file = new File(fname);
				dao.deleteTempPlantsByID(vo);
				dao.deleteAllComments(vo2);//도감관련 댓글 다 삭제
				file.delete();
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		//ID에 해당하는 도감 전부 삭제하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/deleteallTempPlants",method=RequestMethod.DELETE)
		public Map<String,String> deleteallTempPlantsByID(@RequestBody Map<String,Object> p){
			////System.out.println("Controller start");
			TempPlantsVO vo=new TempPlantsVO();
			vo.setUid((String)p.get("uid"));
			////System.out.println("Controller");
			Map<String, String> res=new HashMap();
			try {
				List<TempPlantsVO> all=dao.selectTempPlants(vo);
				dao.deleteAllTempPlants(vo);
				for(TempPlantsVO v: all) {
					CommentVO vo2=new CommentVO();
					vo2.setUid(v.getUid());
					vo2.setBid(v.getBid());
					dao.deleteAllComments(vo2);//도감관련 댓글 다 삭제
					
					String fname=v.getFsImg_1();
					String[] lst=fname.split("/");
					fname=filePath+lst[lst.length-1];
					File file = new File(fname);//파일도 삭제
					file.delete();
				}
			}catch(Exception ex) {
				System.out.println(ex);
				res.put("status", "1062");//sql에서 에러남
				res.put("Exception", ex.getMessage());
				return res;
			}
			////System.out.println("Controller finished");
			res.put("status", "OK");
			return res;
		}
		
		/////////////////////////////comments
		//UID,bid,cid로 comment 하나만 가져오기
		@ResponseBody
		@RequestMapping(value="/TempPlants/getoneComments",method= RequestMethod.POST)
		public Map<String,Object> getoneComments(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			vo.setCid(((Integer)param.get("cid")).intValue());
			CommentVO comments=null;
			Map<String, Object> res=new HashMap();
			try {
				comments=dao.selectoneComment(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			res.put("data", comments);
			return res;
		}
		
		//UID와 bid로 tempPlants에 대한 comments들 가져오기
		@ResponseBody
		@RequestMapping(value="/TempPlants/getComments",method= RequestMethod.POST)
		public Map<String,Object> getALLComments(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			List<CommentVO> comments=null;
			Map<String, Object> res=new HashMap();
			try {
				comments=dao.selectALLComments(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			res.put("data", comments);
			return res;
		}
		
		//comment 달기
		@ResponseBody
		@RequestMapping(value="/TempPlants/Comment",method= RequestMethod.POST)
		public Map<String,Object> insertComment(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			vo.setDetail((String)param.get("detail"));
			vo.setCmuid((String)param.get("cmuid"));
			Map<String, Object> res=new HashMap();
			try {
				dao.insertComments(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			return res;
		}
		
		//comment 수정하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/Comment",method= RequestMethod.PUT)
		public Map<String,Object> updateComment(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setCid(((Integer)param.get("cid")).intValue());
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			vo.setDetail((String)param.get("detail"));
			vo.setCmuid((String)param.get("cmuid"));
			Map<String, Object> res=new HashMap();
			try {
				dao.updateComments(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			return res;
		}
		
		//comment 하나만 삭제하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/Comment",method= RequestMethod.DELETE)
		public Map<String,Object> deleteComment(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setCid(((Integer)param.get("cid")).intValue());
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			vo.setCmuid((String)param.get("cmuid"));
			Map<String, Object> res=new HashMap();
			try {
				dao.deleteoneComments(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			return res;
		}
		
		//comment 전체 삭제하기
		@ResponseBody
		@RequestMapping(value="/TempPlants/AllCommentDel",method= RequestMethod.DELETE)
		public Map<String,Object> deleteallComment(@RequestBody Map<String, Object> param){
			//System.out.println("select getComments Controller까지 됨");
			CommentVO vo=new CommentVO();
			vo.setUid((String)param.get("uid"));
			vo.setBid(((Integer)param.get("bid")).intValue());
			Map<String, Object> res=new HashMap();
			try {
				dao.deleteAllComments(vo);
			}catch(Exception ex) {//에러가 발생할 경우
				res.put("status", "not OK");
				res.put("message",ex.getMessage());
				return res;
			}
			res.put("status", "OK");
			return res;
		}
}