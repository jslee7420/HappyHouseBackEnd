package com.ssafy.happyhouse.qna.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Question {

	private int qnaId;
	private String questionAuthor;
	private String questionPwd;
	private String questionTitle;
	private String questionContent;
	private String questionCreatedTime;
	private String questionEditedTime;
	private Answer answer;
	
}
