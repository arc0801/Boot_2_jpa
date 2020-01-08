package com.arc.b1.member;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arc.b1.util.FilePathGenerator;
import com.arc.b1.util.FileSaver;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	public MemberVO memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		File file = filePathGenerator.getUseClassPathResourc("join");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		memberFilesVO.setMemberVO(memberVO);
		
		memberVO.setMemberFilesVO(memberFilesVO);
		
		return memberRepository.save(memberVO);
	}
	
	public boolean memberIdCheck(String id) throws Exception {
		return memberRepository.existsById(id);
	}
	
	public MemberVO memberUpdate(MemberVO memberVO, MultipartFile files) throws Exception {
		//MemberFilesVO memberFilesVO = null;
		
		if(files.getSize() > 0) {
			File file = filePathGenerator.getUseClassPathResourc("join");
			String fileName = fileSaver.save(file, files);
			System.out.println(fileName);
			
			MemberFilesVO memberFilesVO = memberVO.getMemberFilesVO();
			memberFilesVO.setFname(fileName);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			memberVO.setMemberFilesVO(memberFilesVO);
			memberFilesVO.setMemberVO(memberVO);
		}
		
		return memberRepository.save(memberVO);
	}
	
	public void memberDelete(MemberVO memberVO) throws Exception {
		memberRepository.deleteById(memberVO.getId());
	}
}
