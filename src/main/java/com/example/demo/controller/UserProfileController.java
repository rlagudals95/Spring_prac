package com.example.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
// 유저 관련 api를 처리해주는 컨트롤러
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;


@RestController // 이렇게 해주면 spring이 이 클래스를 알아서 컨트롤러로 인식함
public class UserProfileController {
	
	// spring이 UserProfileController을 만들고 그 직후에 호출을 하게됨
	private Map<String, UserProfile> userMap;
	
	// userMap에 기본으로 3명의 데이터를 Map으로 가지고 있는 class
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "홍길동", "111-1111","서울시 강남구 대치 1동"));
		userMap.put("2", new UserProfile("2", "홍길자", "111-1112","서울시 강남구 대치 2동"));
		userMap.put("3", new UserProfile("3", "홍길순", "111-1113","서울시 강남구 대치 3동"));
	}
	
	// id를 인자로 받아 해당 userProfile 정보를 son형태로 전달하는 
	@GetMapping("/user/{id}")
	// 이 api는 path id 변수를 이용하기 때문
	// @PathVariable("id") 이 인식 > 그것을 string id 로 인식 > api 호출
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id); // 요청 받은 id를 받아 해당 id 정보를 res로 줌
	}

	// UserProfile을 리스트형태를 리턴
	// 모든 유저정보를 res값으로 보내줌
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	// 수정 api
	@PutMapping("/user/{id}")
	public void putUserProfile
	// 이름, 번호, 주소를 파라미터로 전달받고
	(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address ) {
			//UserProfile을 가져와 그 형식을 userProfile에도 적용시켜주고
			UserProfile userProfile = new UserProfile(id,name, phone, address );
			//id를 key로 하는 userProfile객체를 추가한다
			userMap.put(id , userProfile);
	}
	
	
}

