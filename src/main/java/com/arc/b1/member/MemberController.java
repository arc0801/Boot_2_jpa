package com.arc.b1.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
//	@GetMapping("memberFileDown")
//	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
//		
//		if(memberFilesVO != null) {
//			mv.addObject("memberfiles", memberFilesVO);
//			mv.addObject("path", "upload");
//			mv.setViewName("fileDown");
//		}else {
//			mv.addObject("msg", "No Image File");
//			mv.addObject("path", "./memberPage");
//			mv.setViewName("common/result");
//		}
//		
//		return mv;
//	}
//	
//	@GetMapping("memberPage")
//	public void memberPage() throws Exception {
//		
//	}
	
	@GetMapping("memberDelete")
	public ModelAndView memberDelete(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		memberService.memberDelete(memberVO);
		
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Delete Success");
		mv.addObject("path", "/");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("memberUpdate")
	public void memberUpdate(HttpSession session, Model model) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("memberVO", memberVO);
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, MultipartFile files, HttpSession session) throws Exception {
		//System.out.println("files : "+ files.getSize());
		MemberVO loginVO = (MemberVO)session.getAttribute("member");
		
		memberVO.setMemberFilesVO(loginVO.getMemberFilesVO());
		
		memberVO = memberService.memberUpdate(memberVO, files);
		
		session.setAttribute("member", memberVO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Update Success");
		mv.addObject("path", "./memberPage");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("memberPage")
	public void memberPage(HttpSession session) throws Exception {
		
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {
		
	}

	
//	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.memberLogin(memberVO);
		
		String msg = "Login Fail";
		
		if(memberVO != null) {
			msg = "Login Success";
			session.setAttribute("member", memberVO);
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		
		return mv;
	}
	
//	@PostMapping("memberLogin")
//	public ModelAndView memberLogin(/*@SessionAttribute */MemberVO memberVO, HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		memberVO = memberService.memberLogin(memberVO);
//		
//		String msg = "Login Fail";
//		
//		if(memberVO != null) {
//			msg = "Login Success";
//			session.setAttribute("member", memberVO);
//		}
//		mv.setViewName("common/result");
//		mv.addObject("msg", msg);
//		mv.addObject("path", "../");
//		
//		return mv;
//	}
	
	@ModelAttribute
	public MemberVO getMemberVO() throws Exception {
		//매개변수에 MemberVO memberVO 안쓰고, 모든 메서드에 집어넣겠다
		return new MemberVO();
	}
	
	@GetMapping("memberJoin")
	public String memberJoin() throws Exception {
		//매개변수에 MemberVO memberVO를 넣어주면 이것과 같은 말이다. 암시적으로~. 밑에 거 참고.
		//MemberVO memberVo = new MemberVO();
		//model.addAttribute("memberVO", memberVO);
		
		return "member/memberJoin";
	}
	
	@PostMapping("memberIdCheck")
	@ResponseBody//view를 찾지 않고, 결과물을 바로 json으로 보내줌.
	public boolean memberIdCheck(String id) throws Exception {
		return memberService.memberIdCheck(id);
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberVO = memberService.memberJoin(memberVO, files);
		
		String msg = "Join Fail";
		String path = "../";
		
		if(memberVO != null) {
			msg = "Join Success";
			path = "memberLogin";
		}else {
		}
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;
	}
	
	//@GetMapping("memberJoin")
	//public String memberJoin(Model model) throws Exception {
	//	model.addAttribute("memberVO", new MemberVO());
	//	
	//	return "member/memberJoin";
	//}
	
//	@PostMapping("memberJoin")
//	public ModelAndView memberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile files) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		if(memberService.memberJoinValidate(memberVO, bindingResult)) {
//		//if(bindingResult.hasErrors()) {
//			mv.setViewName("member/memberJoin");
//		}else {
//		
//			int result = memberService.memberJoin(memberVO, files);
//			String msg = "Join Fail";
//			String path = "../";
//			
//			if(result>0) {
//				msg = "Join Success";
//			}
//			mv.setViewName("common/result");
//			mv.addObject("msg", msg);
//			mv.addObject("path", path);
//		
//		}
//		return mv;
//	}
}
