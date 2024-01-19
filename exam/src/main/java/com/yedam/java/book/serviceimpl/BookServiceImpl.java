package com.yedam.java.book.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> getBookAll() {
		return bookMapper.selectBookList();
	}
	@Override
	public BookVO getBookInfo(BookVO bookVO) {
		return bookMapper.selectBookInfo(bookVO);
	}
	@Override
	public int insertBook(BookVO bookVO) {
		int result = bookMapper.insertBook(bookVO);
		if(result == 1) {
			return bookVO.getBookno();
			
		}else {
			return -1;
		}
	}
	@Override
	public Map<String, Object> updateBook(BookVO bookVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = bookMapper.updateBook(bookVO);
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", bookVO);
		return map;
	}
	@Override
	public List<BookRentVO> getRentAll() {
		return bookMapper.selectRentList();
	}

}
