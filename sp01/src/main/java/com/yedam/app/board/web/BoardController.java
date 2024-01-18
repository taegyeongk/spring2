package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//전체조회 URI - boardList / return board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) { //조회는 반드시 페이지를 돌려줘야하기 때문에 모델이 필요하다.
		List <BoardVO> list = boardService.getBoardAll();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	//단건조회 URI - boardInfo / parameter BoardVO  / return - board/boardInfo
	@GetMapping("boardInfo")
	public String BoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}
	
	
	//등록 - 빈 페이지 URI - boardInsert / board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert"; //board폴더 밑에 jsp
	}
	
	//등록 - 처리 URI - boardInsert / parameter BoardVO  / return - 전체조회 다시호출 -> redirect 사용
	@PostMapping("boardInsert")
	public String insertBoardProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:boardList";
	}
	
	//수정 - 별도페이지 URI - boardUpdate / parameter BoardVO  / return - board/boardUpdate
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoard(BoardVO boardVO){
		return boardService.updateBoard(boardVO);
	}
	
	//수정 - 처리 URI - boardUpdate / parameter BoardVO  / return - 수정결과 데이터(Map)
	@PostMapping("boardUpdateProcess")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestBody BoardVO boardVO) {
		return boardService.updateBoard(boardVO);

	}
	
	//삭제  URI - boardDelete / return 
}
