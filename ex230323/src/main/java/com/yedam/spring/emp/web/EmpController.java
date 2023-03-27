package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET방식
	//등록, 수정, 삭제 -> POST방식
	
	
	//전체조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {
		//Model -> 요청할때 딸려오는 데이터가 없으므로 model에 데이터 담아서 페이지에 보냄
		model.addAttribute("empList",empService.getEmpAll());
		return "emp/empList"; //views폴더 밑에
	}
	
	//단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	
	//등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm(){
		return "emp/empInsert";
	}
	
	
	
	//등록-Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId== -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다." + "\n등록된 사원의 사번은 " + empId + "입니다."; 
		}
		rrtt.addFlashAttribute("result", result);
		
		return "redirect:empList";
	}
	
	//수정 - Process 
	// 1) Client - JSON -> Server
	// 2) Server - text -> Client
	@PostMapping("/empUpdate")
	@ResponseBody
	//@ResponseBody => json으로 넘어온 데이터 처리
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	@PostMapping("/empDelete")
	@ResponseBody
	public String empDeleteProcess(@RequestParam int employeeId) {
		Map<String,String> map = empService.deleteEmp(employeeId);
		return map.get("결과");
	}


}
