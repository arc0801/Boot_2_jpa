package com.arc.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Test
	void selectTest() {
		MemberFilesVO memberFilesVO = memberFilesRepository.findById(3).get();
		System.out.println(memberFilesVO.getFname());
		System.out.println(memberFilesVO.getMemberVO().getId());
	}
	
	//@Test
	void test() {
		//long count = memberFilesRepository.count();
		//System.out.println(count);
		//memberFilesRepository.deleteById(8);
		/*
		List<MemberFilesVO> list = memberFilesRepository.findAll();
		for(MemberFilesVO memberFilesVO:list) {
			System.out.println(memberFilesVO.getFname());
		}
		*/
		/*
		Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
		Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
		MemberFilesVO memberFilesVO = opt.get();
		MemberFilesVO memberFilesVO2 = opt2.get();
		System.out.println(memberFilesVO == memberFilesVO2);
		*/
		/*
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId("a");
		memberFilesVO.setFname("a.jpg");
		memberFilesVO.setOname("a.jpg");
		
		memberFilesRepository.save(memberFilesVO);
		*/
//		List<MemberFilesVO> list = memberFilesRepository.findById("a");
//		for(MemberFilesVO memberFilesVO:list) {
//			System.out.println(memberFilesVO.getFname());
//		}
	}

}
