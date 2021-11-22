package com.ssafy.happyhouse.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.user.model.dto.Bookmark;
import com.ssafy.happyhouse.user.model.dto.User;

public interface UserService {
	
	User checkUserId(String userId) throws SQLException;
	void addUser(User user) throws SQLException;
	void modifyUser(User user) throws SQLException;
	void removeUser(String userId) throws SQLException;
	User loginUser(User user) throws SQLException;
	
	void addBookmark(Bookmark bookmark);
	List<Bookmark> findBookmarkList(String userId);
	void removeBookmark(Bookmark bookmark);

}