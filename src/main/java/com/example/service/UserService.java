package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.vo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	// private final UserMapper userMapper;  // final은 생성자에서만 초기화할 수 있다. setter메소드로 적어놓은 건 초기화할 수 없다.
	
	/* 
	    아래 코드를 적으면 @Service 있는 곳에 @RequiredArgsConstructor를 적은 것과 같음
		@Autowired
		public UserService(UserMapper userMapper) {
			this.userMapper = userMapper;
		}
	*/
	
	public List<User> getAllUsers() {
		return userMapper.getUsers();
	}
	
	public User getUser(String userId) {
		return userMapper.getUserById(userId);
	}
	
	public User saveUser(User user) {
		// id, email 중복체크 코드는 생략합니다.
		userMapper.insertUser(user);
		return userMapper.getUserById(user.getId());
	}

	public User deleteUser(String userId) {
		User user = userMapper.getUserById(userId);
		user.setDeleted("Y");
		userMapper.updateUser(user);
		
		return userMapper.getUserById(userId);
	}
	
	public List<String> getUserRoles(String userId) {
		return userMapper.getUserRoles(userId);
	}
}
