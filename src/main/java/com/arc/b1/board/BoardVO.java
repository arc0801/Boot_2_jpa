package com.arc.b1.board;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BoardVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String writer;
	private String contents;
	@CreationTimestamp //현재시간 알아서 넣어줌
	private Date regDate;
	private int hit;
	
}
