package com.ssafy.happyhouse.qna.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.qna.model.dto.Answer;
import com.ssafy.happyhouse.qna.model.dto.Question;
import com.ssafy.happyhouse.qna.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public void addQuestion(Question question) {
		 qnaMapper.insertQuestion(question);
	}

	@Override
	public Question findQuestion(int qnaId) {
		return qnaMapper.selectQuestion(qnaId);
	}

	@Override
	public void modifyQuestion(Question question) {
		qnaMapper.updateQuestion(question);
	}

	@Override
	public void removeQuestion(int qnaId) {
		qnaMapper.deleteQuestion(qnaId);
	}

	@Override
	public List<Question> findAllQuestion() {
		return qnaMapper.selectQnustionList();
	}

	@Override
	public void addAnswer(int qnaId, Answer answer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qnaId", qnaId);
		map.put("answer", answer);
		
		qnaMapper.insertAnswer(map);
	}

	@Override
	public void modifyAnswer(int qnaId, Answer answer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qnaId", qnaId);
		map.put("answer", answer);
		
		qnaMapper.updateAnswer(map);
	}

	@Override
	public void removeAnswer(int qnaId) {
		qnaMapper.deleteAnswer(qnaId);
	}

}
