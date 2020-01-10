package com.arc.b1.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.arc.b1.board.qna.QnaFilesVO;
import com.arc.b1.board.qna.QnaRepository;
import com.arc.b1.board.qna.QnaService;
import com.arc.b1.board.qna.QnaVO;

@SpringBootTest
//@Transactional
class QnaRepositoryTest {

	@Autowired
	private QnaRepository qnaRepository;
	@Resource
	private QnaService qnaService;
	
	
	@Test
	void columnTest() throws Exception {
		List<Object[]> obj = qnaRepository.qnaSelect(3);
		for (Object[] object : obj) {
			for (Object obj2 : object) {
				System.out.println(obj2);
			}
		}
	}
	
	//@Test
	void updateTest() throws Exception {
		qnaService.qnaUpdate();
	}
	
	//@Test
	void selectOneTest() throws Exception {
		QnaVO qnaVO = qnaRepository.findQnaVO(3);
		
		System.out.println(qnaVO.getTitle());
		System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
	}
	
	//@Test
	void selectTest() throws Exception {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
		
		//List<QnaVO> list = qnaRepository.findByNumGreaterThanOrderByRefDescStepAsc(0);
		
		List<QnaVO> list = qnaRepository.findQnas();
		
		for (QnaVO qnaVO : list) {
			System.out.println(qnaVO.getTitle());
			
			for (QnaFilesVO qnaFilesVO : qnaVO.getQnaFilesVOs()) {
				System.out.println(qnaFilesVO.getFname());
			}
		}
	}
	
	//@Test
	void test() {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("b");
		qnaVO.setWriter("b");
		qnaVO.setContents("b");
		
		List<QnaFilesVO> list = new ArrayList<QnaFilesVO>();
		
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("a1F.jpg");
		qnaFilesVO.setOname("a1O.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		
		list.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("a2F.jpg");
		qnaFilesVO.setOname("a2O.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		
		list.add(qnaFilesVO);
		
		qnaVO.setQnaFilesVOs(list);
		
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		
		qnaRepository.save(qnaVO);
		
		System.out.println(qnaVO.getNum());
		System.out.println(qnaVO.getTitle());
	}

}
