package com.arc.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arc.b1.board.BoardVO;
import com.arc.b1.util.FilePathGenerator;
import com.arc.b1.util.FileSaver;

@Service//("test") 이름 줄 수 있음
//@Qualifier("test")
@Transactional //lazy loading 발동 조건. method 각각 줘도 됨.
public class NoticeService {

	@Autowired //@Resource 써도 됨
	private NoticeRepository noticeRepository;
	@Autowired
	private NoticeFilesRepository noticeFilesRepository;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileSaver fileSaver;
	
	
	public Page<NoticeVO> getAllNotice(Pageable page){
		return noticeRepository.findAll(page);
	}
	
	public Page<NoticeVO> noticeList(Pageable page) throws Exception {
		Page<NoticeVO> list = noticeRepository.findByNumGreaterThanOrderByNumDesc(0, page);
//		for (NoticeVO noticeVO : list) {
//			noticeVO.getNoticeFilesVOs();
//		}
		
		return list;
	}
	
	public Optional<NoticeVO> noticeSelect(int num) throws Exception {
		return noticeRepository.findById(num);
	}
	
	public void noticeWrite(NoticeVO noticeVO, List<MultipartFile> files) throws Exception {
		List<NoticeFilesVO> noticeFilesVOs = null;
		//파일 유무 검증
		boolean check = false;
		
		if(files.size() > 0) {
			for(MultipartFile multipartFile: files) {
				if(multipartFile.getSize() > 0) {
					check = true;
					break;//파일이 한 개 이상이면 되니까, 한개라도 찾으면 바로 반복문 벗어남
				}
			}//for
			
			if(check) {
				//검증이 끝났으니 list를 만들어준다
				noticeFilesVOs = new ArrayList<NoticeFilesVO>();
				//파일 저장
				for (MultipartFile multipartFile : files) {
					
					if(multipartFile.getSize() > 0) {
						NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
						File file = filePathGenerator.getUseClassPathResourc("upload/notice");
						String fileName = fileSaver.save(file, multipartFile);
						
						noticeFilesVO.setFname(fileName);
						noticeFilesVO.setOname(multipartFile.getOriginalFilename());
						noticeFilesVO.setNoticeVO(noticeVO);
						
						noticeFilesVOs.add(noticeFilesVO);
					}
				}//for
				
				noticeVO.setNoticeFilesVOs(noticeFilesVOs);
				
			}//if2
			
		}//if1
		
		noticeRepository.save(noticeVO);
	}
}
