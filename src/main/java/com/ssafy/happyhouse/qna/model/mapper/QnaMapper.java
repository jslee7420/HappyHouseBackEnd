package com.ssafy.happyhouse.qna.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.qna.model.dto.Answer;
import com.ssafy.happyhouse.qna.model.dto.Question;


@Mapper
public interface QnaMapper {
	
	void insertQuestion(Question question);
	Question selectQuestion(int qnaId);
	void updateQuestion(Question question);
	void deleteQuestion(int qnaId);
	List<Question> selectQnustionList();
	void insertAnswer(Map<String, Object> map);
	void updateAnswer(Map<String, Object> map);
	void deleteAnswer(int qnaId);
}
