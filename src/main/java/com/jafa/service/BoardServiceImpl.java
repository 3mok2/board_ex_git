package com.jafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jafa.domain.BoardVO;
import com.jafa.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

//@Component
//@Repository
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	@Override
	public List<BoardVO> getList() {
		return boardRepository.getList();
	}

	@Override
	public void register(BoardVO board) {
		boardRepository.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardRepository.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardRepository.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		return boardRepository.delete(bno)==1;
	}

}
