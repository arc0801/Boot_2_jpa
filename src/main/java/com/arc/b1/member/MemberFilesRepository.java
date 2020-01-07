package com.arc.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{
	
	List<MemberFilesVO> findById(String id);//매개변수에 들어가는 변수명은 아무 상관없음.
}
