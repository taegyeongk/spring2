package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	//전체조회
		public List<BookVO> selectBookList();
		//단건조회
		public BookVO selectBookInfo(BookVO bookVO);
		//등록
		public int insertBook(BookVO bookVO);
		//수정
		public int updateBook(BookVO bookVO);
		
		public List<BookRentVO> selectRentList();
		
}
