package com.ssafy.happyhouse.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.jwt.JwtService;
import com.ssafy.happyhouse.user.model.dto.Bookmark;
import com.ssafy.happyhouse.user.model.dto.User;
import com.ssafy.happyhouse.user.model.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class UserContorller{
	
	public static final Logger logger = LoggerFactory.getLogger(UserContorller.class);
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> userIdCheck(@PathVariable String id) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(userService.checkUserId(id) != null) {
			map.put("message", "fail");
			return ResponseEntity.ok(map);
		}
		map.put("message", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping()
	public ResponseEntity<Object> userAdd(@RequestBody User user) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(userService.checkUserId(user.getUserId()) != null) {
			map.put("message", "fail");
			return ResponseEntity.ok(map);
		}
		userService.addUser(user);
		map.put("message", "success");
		return ResponseEntity.ok(map);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> userModify(@RequestBody User user, @PathVariable String id, HttpServletRequest request) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			if(!user.getUserId().equals(id)) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			if(userService.checkUserId(id) == null) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			userService.modifyUser(user);
	        map.put("userInfo", user);
			map.put("message", "success");
			return ResponseEntity.ok(map);
			
		} else {
			logger.error("사용 불가능 토큰!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> userRemove(@PathVariable String id, HttpServletRequest request) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			if(userService.checkUserId(id) == null) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			userService.removeUser(id);
			map.put("message", "success");
			return ResponseEntity.ok(map);
	        
		} else {
			logger.error("사용 불가능한 토큰!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	} 
	
	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestBody User user) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 유저 존재 확인
		User signedUser = userService.loginUser(user);
		if(signedUser == null) {
			map.put("message", "fail");
			return ResponseEntity.ok(map);
		}
		String token = jwtService.create("userid", signedUser.getUserId(), "access-token");// key, data, subject
		
		map.put("userInfo", signedUser);
		map.put("access-token", token);
		map.put("message", "success");
		
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/{id}/bookmark")
	public ResponseEntity<Object> bookmarkList(@PathVariable String id, HttpServletRequest request) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			if(userService.checkUserId(id) == null) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			map.put("bookmarks", userService.findBookmarkList(id));
			map.put("message", "success");
			return ResponseEntity.ok(map);
	        
		} else {
			logger.error("사용 불가능한 토큰!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	} 
	@PostMapping("/{id}/bookmark")
	public ResponseEntity<Object> bookmarkAdd(@PathVariable String id, @RequestBody Bookmark bookmark, HttpServletRequest request) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			if(userService.checkUserId(id) == null) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			userService.addBookmark(bookmark);
			map.put("message", "success");
			return ResponseEntity.ok(map);
			
		} else {
			logger.error("사용 불가능한 토큰!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	} 
	
	@DeleteMapping("/{id}/bookmark")
	public ResponseEntity<Object> bookmarkRemove(@PathVariable String id, @RequestBody Bookmark bookmark, HttpServletRequest request) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			if(userService.checkUserId(id) == null) {
				map.put("message", "fail");
				return ResponseEntity.ok(map);
			}
			userService.removeBookmark(bookmark);
			map.put("message", "success");
			return ResponseEntity.ok(map);
			
		} else {
			logger.error("사용 불가능한 토큰!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	} 
	
//	@GetMapping("/login/check")
//	public ResponseEntity<Object> userLoginCheck(HttpSession session) throws Exception {
//		if(session.getAttribute("userInfo") != null) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.noContent().build();
//    }
	
	
//	@PostMapping("/logout")
//	public ResponseEntity<Object> userLogout(HttpSession session) throws Exception {
//        session.invalidate();
//        return ResponseEntity.ok().build();
//    }
//	
//	@GetMapping()
//	public ResponseEntity<Object> userDetail(HttpSession session) throws Exception {
//		User user = (User) session.getAttribute("userInfo");
//		if(user == null) {
//			return ResponseEntity.badRequest().build();
//		}
//        return ResponseEntity.ok(user);
//    } 
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//	
//	@GetMapping("/join")
//	public String join() {
//		return "user_join";
//	}
//	
//	@GetMapping("/profile")
//	public String profile() {
//		return "user_profile";
//	}
	
}
