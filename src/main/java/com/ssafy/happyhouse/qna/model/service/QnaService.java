package com.ssafy.happyhouse.qna.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.qna.model.dto.Answer;
import com.ssafy.happyhouse.qna.model.dto.Question;

public interface QnaService {
	
	void addQuestion(Question question);
	Question findQuestion(int qnaId);
	void modifyQuestion(Question question);
	void removeQuestion(int qnaId);
	List<Question> findAllQuestion();
	void addAnswer(int qnaId, Answer answer);
	void modifyAnswer(int qnaId, Answer answer);
	void removeAnswer(int qnaId);
}
