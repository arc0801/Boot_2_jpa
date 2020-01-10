package com.arc.b1.board.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arc.b1.util.FilePathGenerator;
import com.arc.b1.util.FileSaver;

@Service
@Transactional
public class QnaService {
	
	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private QnaFilesRepository qnaFilesRepository;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	public void qnaUpdate() throws Exception {
		qnaRepository.qnaUpdate("c", "c", 4);
	}
	
}
