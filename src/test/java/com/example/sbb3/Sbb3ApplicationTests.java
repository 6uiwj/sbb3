package com.example.sbb3;

import com.example.sbb3.answer.AnswerRepository;
import com.example.sbb3.question.QuestionRepository;
import com.example.sbb3.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sbb3ApplicationTests {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuestionService questionService;

	//@Transactional
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

//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("테스트 제목1", q.getSubject());
		//값의 존재 여부를 모르므로 일단 optional객체에 담음
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) { //값이 있으면 question 객체에 담음
//			Question q = oq.get();
//			assertEquals("테스트 제목1", q.getSubject());
//		}
//		Question q2 = this.questionRepository.findBySubject("테스트 제목1");
//		assertEquals(1,q2.getId()); //기댓값 1이 실제값과 같은지 확인
//
//		Question q3 = this.questionRepository.findBySubjectAndContent("테스트 제목1", "테스트 내용1");
//		assertEquals(1, q3.getId());
//
//			List<Question> ql = this.questionRepository.findBySubjectLike("테%");
//			Question q4 = ql.get(0);
//			assertEquals(1,q4.getId());


//			Optional<Question> q5 = this.questionRepository.findById(1);
//			assertTrue(q5.isPresent()); //q5가 존재하는지 테스트
//			Question q6 = q5.get();
//			q6.setSubject("테스트 제목1 수정");
//			this.questionRepository.save(q6);

//			Question q7 = this.questionRepository.findBySubject("테스트 제목2");
//			q7.setSubject("테스트 제목2 수정");
//			this.questionRepository.save(q7);

			//질문데이터 삭제
//		assertEquals(2,this.questionRepository.count());
//		Optional<Question> oq2 = this.questionRepository.findById(1);
//		assertTrue(oq2.isPresent());
//		Question q8 = oq2.get();
//		this.questionRepository.delete(q8);
//		assertEquals(1, this.questionRepository.count());

//		Optional<Question> q = this.questionRepository.findById(2);
//		assertTrue(q.isPresent());
//		Question question = q.get();
//
//		Answer answer = new Answer();
//		answer.setQuestion(question);
//		answer.setContent("테스트 답변1");
//		answer.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(answer);

//		Optional<Answer> a = this.answerRepository.findById(1);
//		assertTrue(a.isPresent());
//		Answer answer = a.get();
//		assertEquals(2, answer.getQuestion().getId());
////------------------------------------------------
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		List<Answer> answerList = q.getAnswerList();
//		assertEquals(1, answerList.size());
//		assertEquals("테스트 답변",answerList.get(0).getContent());

		//테스트를 위한 대량 데이터 만들기
		for(int i = 0; i <= 300; i++) {
			String subject = String.format("테스트 데이터:[%03d]",i);
			String content = "내용";
			this.questionService.create(subject,content,null);

		}
		}

	}


