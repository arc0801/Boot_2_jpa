package com.arc.b1.board.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	List<NoticeVO> findByNumGreaterThanOrderByNumDesc(int index);
	
}
