package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {
	
	List<BoardVO> getList();
	
	void insert(BoardVO vo);
	
	// Integer : 삽입된 행의 개수
	Integer insertSelectKey(BoardVO vo);
	
	BoardVO read(Long bno);
	
	// int : 삭제된 행의 개수
	int delete(Long bno);
	
	// int : 수정된 행의 개수
	int update(BoardVO vo);
}
