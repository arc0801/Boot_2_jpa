package com.arc.b1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
}
