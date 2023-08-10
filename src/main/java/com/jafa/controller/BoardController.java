package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.BoardVO;
import com.jafa.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", boardService.getList());
	}
	
	@GetMapping("/get")
	public void get(Long bno, Model model) {
		model.addAttribute("board", boardService.get(bno));
	}

	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		boardService.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}

	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		if(boardService.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
}
