package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	// @Insert : mybatis 관련 어노테이션 
	@Insert("INSERT INTO aaa VALUES(#{num})")
	public void insertAaa(String num);
}
