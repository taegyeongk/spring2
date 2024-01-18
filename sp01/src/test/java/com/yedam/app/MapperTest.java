package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class MapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	//전체조회
	//@Test
	public void selectAll() {
		List<EmpVO> list = empMapper.selectEmpList();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회
	//@Test
	public void selectInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	//등록
	//@Test
	public void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdong@google.com");
		empVO.setHireDate(new Date("24/01/15"));
		empVO.setJobId("IT_PROG");
		empVO.setSalary(10000);
		
		int result = empMapper.insertEmpInfo(empVO);
		assertNotEquals(result, 0);
	}
	
	//수정
	//@Test
	public void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		findVO.setLastName("Kang");
		int result = empMapper.updateEmpInfo(findVO);
		assertNotEquals(result, 0);
	}
	
	//수정 : 특정한 조건을 만족할때에만 모아서 하나의 또 다른 쿼리문을 만들 수 있다.
	//@Test
	public void updateInfoDynamic() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		empVO.setSalary(5200);
		int result = empMapper.updateEmpInfoDynamic(empVO);
		assertNotEquals(result, 0);
	}
	
	//삭제
	//@Test
	public void deleteInfo() {
		int result = empMapper.deleteEmpInfo(207);
		assertNotEquals(result, 0);
	}
	
	@Autowired
	BoardMapper boardMapper;
	//board
	//전체조회
	//@Test
	public void selectBoardAll() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회 
	//@Test
	public void selectBoardInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
		assertEquals(findVO.getTitle(), "게시글1");
	}
	
	//등록 
	//@Test
		public void insertBoard() {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("게시글1");
			boardVO.setContents("내용");
			boardVO.setWriter("작성자");
			boardVO.setImage(null);
			
			int result = boardMapper.insertBoard(boardVO);
			assertNotEquals(result, 0);
		}
	
	//수정
		//@Test
		public void updateBoard() {
			BoardVO boardVO = new BoardVO();
			boardVO.setBno(1);
			BoardVO findVO = boardMapper.selectBoardInfo(boardVO);
			findVO.setTitle("게시글1수정");
			int result = boardMapper.updateBoard(findVO);
			assertNotEquals(result, 0);
		}
	
	//삭제
	//@Test
	public void deleteBoard() {
		int result = boardMapper.deleteBoard(1);
		assertNotEquals(result, 0);	
	}
	
	
	
	
	
}
