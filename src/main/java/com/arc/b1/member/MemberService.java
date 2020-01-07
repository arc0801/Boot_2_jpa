package com.arc.b1.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	public List<MemberFilesVO> memberPage(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		return memberFilesRepository.findById(memberVO.getId());
	}
}
