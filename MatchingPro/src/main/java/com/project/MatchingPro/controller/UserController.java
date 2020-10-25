package com.project.MatchingPro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.MatchingPro.domain.user.User;
import com.project.MatchingPro.domain.user.UserRepository;
import com.project.MatchingPro.test.ResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {	//app,web 둘다적용

	private final UserRepository userRepository;
	private final HttpSession session;
	
	//회원가입
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<String>("ok",HttpStatus.CREATED);
	}
	
	//로그아웃
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		session.removeAttribute("principal");
		//session.invalidate();	//모든 세션 정보 삭제
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
}
