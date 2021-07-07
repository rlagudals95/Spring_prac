package com.example.demo.model;

// 모델 그리고 그 밑에 모델을 만들고 작
public class UserProfile {
	
	// 4개의 필드를 갖는 UserProfile클래스
	private String id;
	private String name;
	private String phone;
	private String address;
	
	// 생성자 source의 generate constructor 
	
	public UserProfile(String id, String name, String phone, String address) {
		// id , name , phone, address 를 파라미터로 받아서 해당된 필드를 채워줌
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}



	// getter & setter를 source로 손쉽게 만들었다
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
