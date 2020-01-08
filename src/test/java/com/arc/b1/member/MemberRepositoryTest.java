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
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("g");
		memberVO.setPw("g");
		memberVO.setName("gg");
		memberVO.setEmail("g@g");
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFnum(14);
		memberFilesVO.setFname("gFname.jpg");
		memberFilesVO.setOname("gOname.jsp");
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
	
	//@Test
	void deleteTest() {
		memberRepository.deleteById("n");
	}
	
	//@Test
	void insertTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("m");
		memberVO.setPw("m");
		memberVO.setName("m");
		memberVO.setEmail("m@m");
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname("mFname.jpg");
		memberFilesVO.setOname("mOname.jpg");
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		//memberRepository.save(memberVO);
		memberFilesRepository.save(memberFilesVO);//이건 안됨
	}
	
	//@Test
	void selectTest() {
		Optional<MemberVO> opt = memberRepository.findById("h");
		MemberVO memberVO = opt.get();
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getMemberFilesVO().getFname());
		System.out.println(memberVO.getMemberFilesVO().getMemberVO().getId());
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
