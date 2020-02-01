package com.mycompany.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.UserDAO;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/*")
public class RestAPIController {

	@Autowired
	UserService service;
	
	@Autowired
	UserVO vo;
	
	@Autowired
	UserDAO dao;
	
	@Autowired
	TokenVO tokenVO;

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	// 단일 회원 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public HashMap<String, Object> selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO vo = service.selectByID(id);
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", vo);

		return map;
	}

	// 전체 회원 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HashMap<String, Object> listAll() throws Exception {
		List<UserVO> userList = service.selectAll();
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", userList);

		return map;
	}

	// 회원 가입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestBody UserVO vo) {
		ResponseEntity<String> resEntity = null;
		try {
			System.out.println("=====POST method called=====");
			logger.info("insertUser method called");
			logger.info(vo.toString());
			// service의 insert 메서드를 호출
			int resSignUp = service.insertUser(vo); // vo 객체를 insert로 전달한 것의 반환값을 resSignUp에 담음
			System.out.println("DB에 추가됐으면 정수 1 반환; resSignUp: " + resSignUp);
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
			System.out.println("resEntity : " + resEntity);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}

	// 토큰 생성
	public String makeToken() {
		int length = 15;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		String[] charArray = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0".split(",");
		for (int i = 0; i < length; i++) {
			buffer.append(charArray[random.nextInt(charArray.length)]);
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	// 인증
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public void authorise(@RequestBody UserVO vo) throws Exception {

		// VO에서 id 추출
		UserVO loginVO = service.login(vo);
		long id = loginVO.getId();
		System.out.println("id: " + id);
		
		//토큰 발행
		String token = makeToken();
		
		// 토큰 VO에 토큰 일련 번호랑 id 저장
		tokenVO.setToken(token);
		tokenVO.setUserId(id);
		
		// 위에서 set한 정보를 DB에 넣기
		service.insertToken(tokenVO);
		
		
//		loginVO = dao.selectByID(vo.getUsername());
//		System.out.println(loginVO);
//		JSONObject userMap = new JSONObject();
//		JSONObject snsMap = new JSONObject();
//		JSONArray resArray = new JSONArray();
//		if (loginVO.getUsername().equals(vo.getUsername())) {
//			try {
//				loginVO.setCreatedAt(null);
//				loginVO.setToken();
//				logger.info("userlogin OK");
//				// System.out.println(loginMember.toString());
//				int result = dao.loginember(loginVO);
//				snsMap.put("code", HttpStatus.OK);
//				snsMap.put("message", "200");
//				userMap.put("token", loginVO.getToken());
//				userMap.put("userID", loginVO.getId());
//				userMap.put("created_At", loginVO.getCreatedAt());
//				snsMap.put("data", userMap);
//				System.out.println("result = " + snsMap);
//			} catch (Exception e) {
//				snsMap.put("code", HttpStatus.BAD_REQUEST);
//				resultArry.add(snsMap);
//			}
//
//		} else {
//			System.out.println("No user!");
//			snsMap.put("Error", "No user");
//
//		}
//		return snsMap;
	}
}
