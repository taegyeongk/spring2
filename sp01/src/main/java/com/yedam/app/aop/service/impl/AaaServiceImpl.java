package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	@Autowired
	AaaMapper aaaMapper;
	
	//트랜잭션 사용할 경우 하나라도 에러가 난다면 실행되지 않기때문에 값이 없음.
	@Transactional
	public void insert() {
		aaaMapper.insertAaa("101");
		aaaMapper.insertAaa("a101");
		
	}
}
