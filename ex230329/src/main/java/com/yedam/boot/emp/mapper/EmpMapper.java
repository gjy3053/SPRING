package com.yedam.boot.emp.mapper;

import java.util.List;

import com.yedam.boot.emp.service.EmpVO;

//@Mapper
public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectAllEmp();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	
}
