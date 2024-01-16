package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

//class 는 bean 으로 만들 수 있음.
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired //기능 수행시 sql 이 필요함
	EmpMapper empMapper;
	
	
	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectEmpList();
	}

	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		if(result == 1) { //정상 등록되었을 때
			return empVO.getEmployeeId();
		}
		else {
			return -1; //정상 등록되지 않았을 경우 employee_id 가 절대 가질 수 없는 -1 값을 반환해준다.
		}
	}

	@Override
	public Map<String, Object> updateEmpInfo(EmpVO empVO) { //value에 object를 사용하는 이유 : 정해진 타입 뿐만 아니라 숫자, 불리언, 문자 또한 한번에 넘기려고 사용하는 이유.
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = empMapper.updateEmpInfo(empVO);
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed); //실행되는 결과값 
		map.put("target", empVO); //실행되는 대상
		return map; // 결과 반환에 따라 쿼리문 값이 잘못 될 수 있다. 데이터는 넣었는데 리턴 안할 경우 원인을 찾을수가 없을 수 있으니 주의 해야한다.리턴 부분은 가능한 미리 작성하기
	} 

	@Override
	public boolean deleteEmpInfo(int empId) {
		int result = empMapper.deleteEmpInfo(empId);
	
		return result == 1 ? true : false; //삭제면 true, 안됬을 경우 false / 사실상 insert 안에 if 문과 같음
		
	}

}
