package com.arc.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.FetchType;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arc.b1.board.BoardVO;
import com.arc.b1.board.notice.NoticeFilesVO;
import com.arc.b1.board.notice.NoticeRepository;
import com.arc.b1.board.notice.NoticeVO;

@SpringBootTest
@Transactional
//fetch = FetchType.LAZY
//@Transactional - 없으면 noticeVO만, 써주면 noticeVO 조회하고, FilesVO 다시 조회
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void insertTest() {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("z");
		noticeVO.setWriter("z");
		noticeVO.setContents("z");
		
//		for (int i=0;i<) {
//			noticeFilesVO.setFname("zFname.jap");
//			noticeFilesVO.setOname("zOname.jsp");
//		}
		
		
		
	}
	
	//@Test
	void selectTest() {
		NoticeVO noticeVO = noticeRepository.findById(1).get();
		System.out.println(noticeVO.getTitle());
		
		for (NoticeFilesVO noticeFilesVO : noticeVO.getNoticeFilesVOs()) {
			System.out.println(noticeFilesVO.getFname());
		}
	}
	
	//@Test
	void test() {
		//List<NoticeVO> list = noticeRepository.findByNumGreaterThanOrderByNumDesc(0);
		//for (NoticeVO noticeVO : list) {
		//	System.out.println(noticeVO.getNum());
		//}
	}

}
