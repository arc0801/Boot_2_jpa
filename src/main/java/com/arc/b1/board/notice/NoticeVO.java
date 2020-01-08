package com.arc.b1.board.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.arc.b1.board.BoardVO;

import lombok.Data;

@Entity
@Table(name = "notice")
@Data //setter, getter, equals, hashcode
public class NoticeVO extends BoardVO {

	//현재 클래스 개수 To 변수 개수
	//fetch = FetchType.LAZY : 조인할 준비만 하고 있다가, 필요할 때 호출하면 그 때 조인을 하겠다
	//fetch = FetchType.EAGER : 처음부터 조인을 해서 가져오겠다
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVOs;
	
}
