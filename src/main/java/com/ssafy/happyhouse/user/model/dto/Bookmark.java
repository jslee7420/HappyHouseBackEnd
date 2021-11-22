package com.ssafy.happyhouse.user.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bookmark {
	
	private int bookmarkId;
	private String userId;
	private int aptCode;

}
