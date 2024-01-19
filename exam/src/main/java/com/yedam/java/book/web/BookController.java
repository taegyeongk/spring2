package com.yedam.java.book.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	//전체
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.getBookAll();
		model.addAttribute("bookList", list);
		return "book/bookList";
	}
	
	@GetMapping("bookrentList")
	public String rentList(Model model) {
		List<BookRentVO> list = bookService.getRentAll();
		model.addAttribute("bookrentList", list);
		return "book/bookrentList";
	}

	
	//단건
	@GetMapping("bookInfo")
	public String bookInfo(BookVO bookVO, Model model) {
		BookVO findVO = bookService.getBookInfo(bookVO);
		model.addAttribute("bookInfo", findVO);
		return "book/bookInfo";
		
	}
	//등록
	@GetMapping("bookInsert")
	public String insertBookForm() {
		return "book/bookInsert";
	}
	@PostMapping("bookInsert")
	public String insertBookProcess(BookVO bookVO) {
		bookService.insertBook(bookVO);
		return "redirect:bookList";
	}
	
	
	//수정
	@GetMapping("bookUpdate")
	public String updateBook(BookVO bookVO, Model model) {
		BookVO findVO = bookService.getBookInfo(bookVO);
		model.addAttribute("bookInfo", findVO);
		return "book/bookUpdate";
	}
	@PostMapping("bookUpdate")
	@ResponseBody
	public Map UpdatebookProcess(@RequestBody BookVO bookVO, Model model) {
		return bookService.updateBook(bookVO);
	}
	
	
	
}
