package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 객체가 entity 라는 것을 알려줌 (DB-JPA-DB)
@Table(name = "new_student")
@Getter
@Builder(toBuilder = true) // setter를 대신해서 내용을 담는다., toBuilder = true는 필드 수정 허용(update)
@NoArgsConstructor // 파라미터가 없는 생성자
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@ToString // 객체 출력시 필드 값들이 보인다. (사용하지 않으면 값이 해쉬값으로 보임)
public class StudentEntity {

	@Id // pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert 할 때 방금 들어간 id 가져옴
	private int id;

	private String name;

	@Column(name = "phoneNumber") // camelCase 경우에 해줘야 한다.
	private String phoneNumber;

	private String email;

	@Column(name = "dreamJob")
	private String dreamJob;

	@Column(name = "createdAt")
	@CreationTimestamp // 시간값이 없어도 현재시간으로 들어감, update 시 변경 x
	private LocalDateTime createdAt;

	@Column(name = "updatedAt")
	@UpdateTimestamp // update 시 시간 변경
	private LocalDateTime updatedAt;
}
