package com.example.sbb3;

import com.example.sbb3.question.Question;
import com.example.sbb3.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Sbb3ApplicationTests {

	@Autowired
	QuestionRepository questionRepository;

	@Test
	void testJPA() {
//		Question q1 = new Question();
//		q1.setContent("테스트 내용1");
//		q1.setSubject("테스트 제목1");
//		q1.setCreateDate(LocalDateTime.now());
//		questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("테스트 제목2");
//		q2.setContent("테스트 내용2");
//		q2.setCreateDate(LocalDateTime.now());
//		questionRepository.save(q2);

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("테스트 제목1", q.getSubject());
	}

}
