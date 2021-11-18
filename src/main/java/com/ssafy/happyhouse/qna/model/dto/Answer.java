package com.ssafy.happyhouse.qna.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Answer {
	
	private String answerAuthor;
	private String answerContent;
	private String answerCreatedTime;
	private String answerEditedTime;
	
}
