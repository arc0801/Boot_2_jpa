package com.arc.b1.board.notice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notice")
public class NoticeVO {

	@Id
	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
}
