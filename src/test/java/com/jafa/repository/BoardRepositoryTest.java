package com.jafa.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;
import com.jafa.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardRepositoryTest extends AppTest {

	@Autowired
	private BoardRepository boardRepository; 
	
	@Test
	@Ignore
	public void testGetList() {
		List<BoardVO> list = boardRepository.getList();
		list.forEach(b-> log.info(b));
	}

	@Test
	@Ignore
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
				.title("새로 작성하는 글...")
				.content("새로 작성하는 글 내용")
				.writer("관리자")
				.build();
		boardRepository.insert(vo);
		log.info(vo);
	}
	
	@Test
	@Ignore
	public void testInsertSelectKey() {
		BoardVO vo = BoardVO.builder()
				.title("새로 작성하는 글...!!!!")
				.content("새로 작성하는 글 내용!!!!")
				.writer("운영자")
				.build();
		boardRepository.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
//	@Ignore
	public void testRead() {
		BoardVO read = boardRepository.read(4L);
		log.info(read);
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
				.bno(1L)
				.title("수정 작성하는 글...!!!!")
				.content("수정 작성하는 글 내용!!!!")
				.writer("관리자")
				.build();
		int count = boardRepository.update(vo);
		log.info("업데이트 된 행의 개수 : " + count);
	}
	
	@Test
	@Ignore
	public void testDelete() {
		int count = boardRepository.delete(1L);
		log.info("삭제 된 행의 개수 : " + count);
	}
	
}
