package com.arc.b1.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "memberFiles")
//@SequenceGenerator(sequenceName = "file_seq", name = "file")
public class MemberFilesVO {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file")//오라클에서 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	private String id;
	private String fname;
	private String oname;
}
