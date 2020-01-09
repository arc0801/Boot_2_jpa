package com.arc.b1.board.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arc.b1.board.BoardVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	@ModelAttribute(name = "boardVO")
	public NoticeVO getnoticeVO() throws Exception {
		return new NoticeVO();
	}
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pageable pageable) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		/*Pageable pageable2 = PageRequest.of(0, 10, Sort.Direction.DESC, "num");*/
		
		Page<NoticeVO> page = noticeService.noticeList(pageable);
		
		List<NoticeVO> list = page.getContent();
		
		System.out.println(pageable.getPageNumber());
		
		mv.addObject("list", list);
		//전체 페이지 개수
		mv.addObject("pageSize", page.getTotalPages());
		//현재 페이지 번호
		mv.addObject("pageNum", pageable.getPageNumber());
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(/* @RequestParam(defaultValue = "0") */ Integer num) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Optional<NoticeVO> opt = noticeService.noticeSelect(num);
		
		if(opt.isPresent()) {
			mv.addObject("select", opt.get());
			mv.setViewName("board/boardSelect");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public String noticeWrite() throws Exception {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("board/boardWrite");
//		mv.addObject("boardVO", new NoticeVO());
//		return mv;
		
		return "board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public String noticeWrite(NoticeVO noticeVO, List<MultipartFile> files) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		files.remove(0);
		noticeService.noticeWrite(noticeVO, files);
		
		return "redirect:./noticeList";
	}
}
