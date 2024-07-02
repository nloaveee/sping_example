package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private StudentRepository studentRepository;

	// lesson07.ex01
	// input: 파라미터 4개
	// output: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder().name(name).phoneNumber(phoneNumber).email(email)
				.dreamJob(dreamJob).build();
		// .createdAt(LocalDateTime.now()) 시간을 수동으로 내가 넣고 싶을때 사용한다.

		return studentRepository.save(student);
	}

	// input: Student
	// output: x
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	// input: id
	// output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
