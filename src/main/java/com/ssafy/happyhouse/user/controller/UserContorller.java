package com.ssafy.happyhouse.user.controller;

import java.net.URI;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
	public ResponseEntity<Object> usercheckUserId(@PathVariable String id) throws Exception {
		if(userService.checkUserId(id) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping()
	public ResponseEntity<Object> userAdd(@RequestBody User user) throws Exception {
		if(userService.checkUserId(user.getUserId()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		userService.addUser(user);
		return ResponseEntity.created(URI.create("/user/"+user.getUserId())).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> userModify(@RequestBody User user, @PathVariable String id, HttpSession session) throws Exception {
		if(!user.getUserId().equals(id)) {
			return ResponseEntity.badRequest().build();
		}
		if(userService.checkUserId(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		userService.modifyUser(user);
		
		if(session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
        session.setAttribute("userInfo", user);
        session.setMaxInactiveInterval(30);
		
		return ResponseEntity.created(null).build();
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> userRemove(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("userInfo");
		if(user == null) {
			return ResponseEntity.badRequest().build();
		}
		
		String id = user.getUserId();
		
		if(userService.checkUserId(id) == null) {
			return ResponseEntity.notFound().build();
		}
		userService.removeUser(id);
		session.invalidate();
		return ResponseEntity.noContent().build();
	} 
	
	@GetMapping("/login/check")
	public ResponseEntity<Object> userLoginCheck(HttpSession session) throws Exception {
		if(session.getAttribute("userInfo") != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
	
	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestBody User user) throws Exception {
        // 유저 존재 확인
        User signedUser = userService.loginUser(user);
        if(signedUser == null) {
        	return ResponseEntity.badRequest().build();
        }
        String token = jwtService.create("userid", signedUser.getUserId(), "access-token");// key, data, subject

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", signedUser);
        map.put("access-token", token);
        
        return ResponseEntity.ok().body(map);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Object> userLogout(HttpSession session) throws Exception {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
	
	@GetMapping()
	public ResponseEntity<Object> userDetail(HttpSession session) throws Exception {
		User user = (User) session.getAttribute("userInfo");
		if(user == null) {
			return ResponseEntity.badRequest().build();
		}
        return ResponseEntity.ok(user);
    } 
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user_join";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "user_profile";
	}
	
}
