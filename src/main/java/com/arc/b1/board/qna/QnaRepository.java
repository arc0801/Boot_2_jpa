package com.arc.b1.board.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer>{

	List<QnaVO> findByNumGreaterThanOrderByRefDescStepAsc(int num) throws Exception;
	
	@Query("select Q from QnaVO Q order by Q.ref desc, Q.step asc")
	List<QnaVO> findQnas() throws Exception;
	
	@Query(value = "select * from QnaVO Q where Q.num = :num", nativeQuery = true)//*쓰고싶으면 nativeQuery
	QnaVO findQnaVO(@Param("num") int num/* , @Param("w") String writer */) throws Exception;
	
	@Modifying /* (clearAutomatically = true) *///update, delete는 선언해줘야 함
	@Query("update QnaVO Q set Q.title = ?1, Q.contents = ?2 where Q.num = ?3")
	void qnaUpdate(String title, String contents, int num) throws Exception;
	
	@Query("select Q.writer, Q.contents from QnaVO Q where num = ?1")
	List<Object[]> qnaSelect(int num) throws Exception;
}
