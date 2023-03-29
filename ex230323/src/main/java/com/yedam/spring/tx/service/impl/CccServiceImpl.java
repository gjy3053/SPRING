package com.yedam.spring.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.CccMapper;
import com.yedam.spring.tx.service.CccService;

@Service
public class CccServiceImpl implements CccService{
	@Autowired
	CccMapper cccMapper;
	
	@Transactional
	@Override
	public void insert() {
		cccMapper.insert("101");
		cccMapper.insert("100");
	}
}
