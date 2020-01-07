package com.arc.b1.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String>{//<VO타입,PK타입>

	MemberVO findByIdAndPw(String id, String pw);
	
	MemberVO findByPw(String pw);
	
}
