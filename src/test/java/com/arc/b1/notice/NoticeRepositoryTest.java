package com.arc.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arc.b1.board.notice.NoticeRepository;
import com.arc.b1.board.notice.NoticeVO;

@SpringBootTest
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void selectTest() {
		Optional<NoticeVO> opt = noticeRepository.findById(1);
		System.out.println(opt.get().getTitle());
	}
	
	//@Test
	void test() {
		List<NoticeVO> list = noticeRepository.findAll();
		for (NoticeVO noticeVO : list) {
			System.out.println(noticeVO.getNum());
		}
	}

}
