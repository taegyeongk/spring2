package com.example.demo.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.MemberVO;
import com.example.demo.member.UserDetailVO;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.service.MemberService;

@Service
public class MemberServiceImpl  implements MemberService, UserDetailsService{
	@Autowired
	MemberMapper mapperMapper;
	
	@Override
	public MemberVO getMember(String mid) {
		return mapperMapper.getMember(mid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = mapperMapper.getMember(username);
		if(vo == null) {
			throw new UsernameNotFoundException("no name");
		}
		return new UserDetailVO(vo);
	}
	
}
