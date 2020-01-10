package com.arc.b1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@ModelAttribute(name = "boardVO")
	public QnaVO getQnaVO() throws Exception {
		return new QnaVO();
	}
	
	
	@GetMapping("qnaList")
	public ModelAndView qnaList(Pageable pageable) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
