package com.example.lesson04.bo;

import java.util.Optional;

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

	// lesson07.ex01.create
	// input: 파라미터 4개
	// output: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder().name(name).phoneNumber(phoneNumber).email(email)
				.dreamJob(dreamJob).build();
		// .createdAt(LocalDateTime.now()) 시간을 수동으로 내가 넣고 싶을때 사용한다.

		return studentRepository.save(student);
	}

	// lesson07.ex01.update
	// input: id, dreamJob
	// output: StudentEntity or null(업데이트 대상이 없을때)
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 => StudentEntity
		// studentRepository.findById(id)가 optional로 감싸져 있어서 orElse를 붙여줘야한다.
		StudentEntity student = studentRepository.findById(id).orElse(null);

		// 엔티티의 데이터 값을 변경해놓는다. (update)
		// toBuilder는 기존 필드값은 유지하고 일부만 변경한다는 의미
		if (student != null) {
			student = student.toBuilder().dreamJob(dreamJob).build();
			// 꼭 객체에 다시 저장!

			// update
			// save 요청
			student = studentRepository.save(student);
		}

		return student;
	}

	// lesson07.ex01.delete
	// input : id
	// output : x
	public void deleteStudentById(int id) {
		// 방법1 )
		/*
		 * StudentEntity student = studentRepository.findById(id).orElse(null);
		 * if(student != null) { studentRepository.delete(student); }
		 */

		// 방법2 )
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);

		// if문을 사용하지 않아도 null이 아닌 경우에만 수행해준다.
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
