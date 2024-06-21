package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05")
public class Lesson05Controller {

	// http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}

	// http://localhost/lesson05/ex02
	@GetMapping("/ex02")
	public String ex02(Model model) {

		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("배");
		fruits.add("수박");
		fruits.add("포도");
		fruits.add("딸기");
		model.addAttribute("fruits", fruits);

		// List<Map<String, Object>>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();

		user.put("name", "홍길동");
		user.put("age", 20);
		user.put("hobby", "여행가기");
		users.add(user);

		user = new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 58);
		user.put("hobby", "달리기");
		users.add(user);

		model.addAttribute("users", users);

		return "lesson05/ex02";
	}
}
