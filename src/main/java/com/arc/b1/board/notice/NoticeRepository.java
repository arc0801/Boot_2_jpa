package com.arc.b1.board.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.arc.b1.board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	//interface는 안쓰면 알아서 public abstract를 넣어줌. 고로 생략가능
	// select * from notice where num > ? order by num desc;
	//List<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num);
	
	Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num, Pageable page) throws Exception;
	
	Page<NoticeVO> findByTitleContainingAndNumGreaterThan(String title, int num, Pageable page) throws Exception;
}
