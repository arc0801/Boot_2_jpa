package com.arc.b1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members") //테이블명과 클래스명이 다를 때 name 속성을 준다
public class MemberVO {
//테이블명과 클래스명을 동일하게 해주면 알아서 연결해줌
	@Id //얘를 primary key로 쓰겠다
	@NotEmpty
	private String id;
	//@Column(name = "password") //컬럼명과 변수명이 다를 때
	//@Column(updatable = false)
	private String pw;
	
	@Transient//테이블과 매핑 안하는 컬럼. 자바단에서만 사용
	private String pw2;
	
	private String name;
	private String email;
	
	//@OneToOne(mappedBy = "Join하는 Entity에 선언된 자기자신의 Entity 변수명")
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	private MemberFilesVO memberFilesVO;
}
