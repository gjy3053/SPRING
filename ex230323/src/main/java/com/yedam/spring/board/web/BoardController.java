package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//전체조회 : URI - getBoardList, RETURN - board/boardList
	@GetMapping("/getBoardList")                  //전체조회는 넘겨오는 데이터는 없으니까 데이터를 보낼때 담아줄 클래스인 MODEL사용
	public String getBoardList(Model model) {  //스프링에서 제공해줌
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";  //타일즈 이용할때 -> board/boardList
									// 이용하지 않을 때 -> boardList
	}
	
	//단건조회 : URI - getBoardInfo, RETURN - board/boardInfo
	@GetMapping("/getBoardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	//등록 - 입력위한 페이지요청 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("/boardInsert")
	public String boardInsertForm(Model model) {
		//객체를 넘길때
		model.addAttribute("boardInfo", boardService.getBoardNO());
		//번호만 넘겨주고 싶을 때
		//model.addAttribute("bno", boardService.getBoardNO().getBno());
		return "board/boardInsert";
	}
	
	//등록 - 등록 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	//post방식으로는 리다이렉트Attribute 잘 하지 않는다
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:getBoardList";	
	}
	
	//수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("/boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}
	
	//수정 - 처리 : URI - boardUpdate, RETURN - 단건조회 다시 호출
	@PostMapping("/boardUpdate")
	public String boardUpdateProcess(BoardVO boardVO) {
		boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno=" + boardVO.getBno();	
	}
	
	//삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	//삭제될 정보이고 글번호만 넘기면 되니까 getmapping
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam int bno) {
		boardService.deleteBoardInfo(bno);		
		return "redirect:getBoardList";
	}
	
}
