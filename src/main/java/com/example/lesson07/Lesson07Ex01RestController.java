package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;

	// C : create
	// http://localhost/lesson07/ex01/create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "김비누";
		String phoneNumber = "010-5874-5687";
		String email = "binu@naver.com";
		String dreamJob = "간호사";

		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}

	// U : update
	// http://localhost/lesson07/ex01/update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 4번인 dreamJob을 변경(의사)
		return studentBO.updateStudentDreamJobById(4, "의사");
	}

	// D : delete
	// http://localhost/lesson07/ex01/delete
	@GetMapping("/delete")
	public String delete() {
		// id가 8번인 데이터 삭제
		studentBO.deleteStudentById(8);

		return "삭제 성공";
	}
}
