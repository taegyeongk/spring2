package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String boardInfo(BoardVO boardVO, Model model) {
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
	
	//수정(단건조회랑 같은 기능을 수행한다.) - 별도페이지 URI - boardUpdate / parameter BoardVO  / return - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	//수정(Ajax) - 처리 URI - boardUpdate / parameter BoardVO(1.@requestbody 사용여부에 따라서 ajax로 통신할때 context-type방법이 달라진다. 2. 를 허용)  / return - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody //안적어주면 404 error 발생
	public Map boardUpdateProcess(@RequestBody BoardVO boardVO, Model model) {
		return boardService.updateBoard(boardVO);
	}
	
	//삭제  URI - boardDelete / return bno /  @RequestParam 를 사용하게되면 필수
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) {
		boardService.deleteBoard(bno);
		return "redirect:boardList";
	}
	
}
