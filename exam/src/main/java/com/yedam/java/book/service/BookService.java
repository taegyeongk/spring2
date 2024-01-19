package com.yedam.java.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	//전체조회
	public List<BookVO> getBookAll();
	//단건조회
	public BookVO getBookInfo(BookVO bookVO);
	//등록
	public int insertBook(BookVO bookVO);
	//수정
	public Map<String, Object> updateBook(BookVO bookVO);

	public List<BookRentVO> getRentAll();
}
