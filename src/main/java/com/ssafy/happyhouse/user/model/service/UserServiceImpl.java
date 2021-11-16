package com.ssafy.happyhouse.user.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.user.model.dto.User;
import com.ssafy.happyhouse.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;
//	@Autowired
//	private JwtService jwtService;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public void addUser(User user) throws SQLException {
		userMapper.insertUser(user);			
	}
	
	@Override
	public User loginUser(User user) throws SQLException {
		// 회원정보 확인 후 인증
		
		return userMapper.selectUser(user);
	}
	
	@Override
	public void modifyUser(User user) throws SQLException {
		// 회원정보 확인 후 인증
		userMapper.updateUser(user);
	}

	@Override
	public void removeUser(String userId) throws SQLException {
		userMapper.deleteUser(userId);
	}

	@Override
	public User checkUserId(String userId) throws SQLException{
		return userMapper.selectUserId(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userMapper.selectUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		} 
		
		return user;
		
	}
}
