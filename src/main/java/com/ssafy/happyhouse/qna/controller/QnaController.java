package com.ssafy.happyhouse.qna.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.qna.model.dto.Answer;
import com.ssafy.happyhouse.qna.model.dto.Question;
import com.ssafy.happyhouse.qna.model.service.QnaService;

@Controller
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping
	public ResponseEntity<Object> QuestionAdd(@RequestBody Question question) throws Exception {
		qnaService.addQuestion(question);
		return ResponseEntity.created(URI.create("/qna/"+question.getQnaId())).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> QustionDetails(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(qnaService.findQuestion(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> questionModify(@RequestBody Question question, @PathVariable Integer id) throws Exception{
		if(qnaService.findQuestion(id) == null) {
			return ResponseEntity.badRequest().build();
		}
		
		qnaService.modifyQuestion(question);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> questionRemove(@PathVariable Integer id) throws Exception{
		if(qnaService.findQuestion(id) == null) {
			return ResponseEntity.badRequest().build();
		}
		
		qnaService.removeQuestion(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Object> QuestionList() throws Exception {
		return ResponseEntity.ok(qnaService.findAllQuestion());
	}
	
	@PostMapping("/{id}/ans")
	public ResponseEntity<Object> answerAdd(@PathVariable Integer id, @RequestBody Answer answer) throws Exception {
		if(qnaService.findQuestion(id) == null) {
			return ResponseEntity.badRequest().build();
		}
		
		qnaService.addAnswer(id, answer);
		return ResponseEntity.created(URI.create("/qna/"+id+"/ans")).build();
	}
	
	@PutMapping("/{id}/ans")
	public ResponseEntity<Object> answerModify(@PathVariable Integer id, @RequestBody Answer answer) throws Exception {		
		Question question = qnaService.findQuestion(id);
		if(question == null || question.getAnswer() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		qnaService.modifyAnswer(id, answer);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/{id}/ans")
	public ResponseEntity<Object> answerRemove(@PathVariable Integer id) throws Exception{
		Question question = qnaService.findQuestion(id);
		if(question == null || question.getAnswer() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		qnaService.removeAnswer(id);
		return ResponseEntity.noContent().build();
	}

}
