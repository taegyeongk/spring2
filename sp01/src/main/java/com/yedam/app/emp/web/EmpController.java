package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 경로가 있어야함
public class EmpController {
	@Autowired // 사용자의 요청에 의한 대응
	EmpService empService;

//	@Autowired //사용자의 요청에 의한 대응
//	DeptService deptService;

	// rest 방식이 아닌 전통 방식 data 가 아닌 페이지를 반환하는 컨트롤러가 필요

	// GET : 단순 조회, 빈 페이지 호출(호출할때 반드시 get 방식이어야함.) 경로에 붙기때문에 보안이 존재하지않는다.
	// POST : 데이터 조작관련(등록, 수정, 삭제) req.body를 요청. 입력한 데이터를 경로에 붙이지는 않는다.

	// 전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list); // 전체 데이터를 model 에 addattributes 를 이용하여 담는다.
		return "emp/empList"; // return에 있는 문장은 servelet context 에게 넘어간다.
	}

	// 사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) { // 사용자에 해당하는 조건을 empVO로 해서 model에 담는다
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo"; // 경로로 리턴
	}

	// 사원등록 - FROM
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}

	// 사원등록 - PROCESS
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) { // 새로운 데이터가 필요함 db에 없는 데이터를 입력, 반환할 데이터가 없으니 model은 필요없다.
		int empId = empService.insertEmpInfo(empVO);

		String path = null;
		if (empId > -1) {
			path = "redirect:empInfo?employeeId=" + empId; // 페이지가 아닌, 새로운 경로를 호출하는 것으로 인식된다. 넘길때는 get 방식이 default
		} else {
			path = "redirect:empList";
		}
		return path;
	}

	// 사원수정 - PROCESS / ajax를 이용해서 사용 => @ResponseBody
	// 1) 클라이언트가 보내는 데이터가 QueryString 인 경우 => 커맨드 객체 이용
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);

	}

	// 2) 클라이언트가 보내는 데이터가 JSON 인 경우 => @RequestBody 이용
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);

	}

	// 사원삭제 - PROCESS / 경우에 따라서 get 방식을 사용할 수는 있으나 post 방식을 사용해주는 것이 제일 좋음.
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) {
		empService.deleteEmpInfo(eid);
		return "redirect:empList";
	}

}
