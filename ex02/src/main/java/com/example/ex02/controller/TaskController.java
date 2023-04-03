package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
// 아이디와 비밀번호를 입력받은후 아이디가 admin일 경우 admin.html로 이동
// 아이디가 user일 경우 user.jsp로 이동
// - admin.jsp
// - user.jsp
	@GetMapping("loginForm")
	public String gologinForm() {
		return "task/task01/login";
	}
	
	@PostMapping("/login")
// 외부에서 전달받은 아이디와 패스워드를 매개변수로 받는다
	public String login(@ModelAttribute("id") String id, String pw) {
		//만약 아이다가 admin일 경우
		if(id.equals("admin")) {
			//admin.jsp로 이동
			return "task/task01/admin";
		}
		//만약 아이다가 admin이 아닐경우 user.jsp로 이동
		return "task/task01/user";
	}
}