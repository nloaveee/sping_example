package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {

	@Autowired
	private ReviewBO reviewBO;

	// http://localhost/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();

		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("길동이");
		review.setPoint(4.5);
		review.setReview("혼밥 세트트트트트");

		// insert 후 성공한 row 수를 return 받는다.
		int rowCount = reviewBO.addReview(review);

		// html
		return "성공한 행의 개수: " + rowCount; // String + int => String

	}

	// http://localhost/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "끄끄", 5.0, "맛있음");

		return "성공한 행의 개수: " + rowCount;
	}
}
