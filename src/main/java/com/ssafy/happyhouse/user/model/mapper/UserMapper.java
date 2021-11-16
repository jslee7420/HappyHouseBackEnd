package com.ssafy.happyhouse.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.user.model.dto.User;

@Mapper
public interface UserMapper {
	
	void insertUser(User user) throws SQLException;     // 회원 등록
	User selectUserId(String userId) throws SQLException; // ID 기반 검색
	User selectUser(User user) throws SQLException;     // ID, PW 기반 Name 리턴
	List<User> selectUserList() throws SQLException;	// 전체 회원리스트 조회
	void updateUser(User user) throws SQLException; 	// 전체 항목 기반 업데이트
	void deleteUser(String userId) throws SQLException; // ID 기반 회원 삭제

}
