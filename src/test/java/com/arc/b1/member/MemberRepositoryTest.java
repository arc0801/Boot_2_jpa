package com.arc.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void memberPage() {
		
	}
	
	//@Test
	void memberLoginTest() {
		MemberVO memberVO = memberRepository.findByIdAndPw("a", "a");
		assertNotNull(memberVO);
	}
	
	//@Test
	void test() {
		//long count = memberRepository.count();//페이징처리
		//boolean check = memberRepository.existsById("a");//id 중복체크
		//List<MemberVO> list = memberRepository.findAll();
		//for(MemberVO memberVO:list) {
		//	System.out.println(memberVO.getId());
		//}
		
		/*
		Optional<MemberVO> opt = memberRepository.findById("aaa");
		if(opt.isPresent()) {
			MemberVO memberVO = opt.get();
			System.out.println(memberVO.getEmail());
		}else {
			System.out.println("No Data");
		}
		*/
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("v");
		memberVO.setPw("v");
		memberVO.setName("ReName");
		//memberVO.setEmail("v@V");
		
		memberRepository.save(memberVO);//없으면 insert, 있으면 update
		
	}

}
