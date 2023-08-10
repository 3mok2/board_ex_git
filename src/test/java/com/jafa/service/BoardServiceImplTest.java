package com.jafa.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.AppTest;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardServiceImplTest extends AppTest{

	@Autowired
	BoardService boardService;
	
	@Test
	public void test() {
		boardService.getList().forEach(b->log.info(b));
	}

}
