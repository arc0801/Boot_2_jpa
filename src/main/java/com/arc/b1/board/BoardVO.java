package com.arc.b1.board;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@EqualsAndHashCode
public class BoardVO {

	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
}
