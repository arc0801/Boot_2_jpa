package com.arc.b1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired NoticeRepository noticeRepository;
	
	public List<NoticeVO> noticeList() throws Exception {
		return noticeRepository.findAll();
	}
}
