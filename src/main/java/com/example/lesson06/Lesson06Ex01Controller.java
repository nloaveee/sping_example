package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson06/ex01")
public class Lesson06Ex01Controller {

	@Autowired
	private UserBO userBO;

	// 회원 가입 화면
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/addUser";
	}

	// AJAX가 하는 요청 => AJAX가 하는 응답은 반드시 String이다., responseBody로 내려야 한다.
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(@RequestParam("name") String name, @RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {

		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);

		// 응답값 - responseBody에 "성공"이 담아서 내려간다.
		return "성공";
	}

	// 회원 가입 성공 화면
	// http://localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser";
	}

}
