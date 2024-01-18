package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
@CrossOrigin("*")  //일부만 허용
//@Controller
@RestController //: rest방식을 사용하는 컨트롤러로 내부에 있는 모든 메서드는 데이터를 반환한다라는 의미로 사용이된다. 해당 어노테이션을 사용하게 되면 각 하위에 있는 @ResponseBody를 생략 할 수 있다.
//rest 방식으로 컨트롤러 사용법
//rest방식은 모든 컨트롤러가 responsebody가 붙어야한다. 코드 양이 줄어든다는 장점이 있으나 어노테이션이 그만큼 많이 붙게됨
public class EmpRestController {
	@Autowired
	EmpService empService;
	
	//전체조회 :  리턴타입이 리스트이며 차이점은 더이상 model 을 사용하여 담지 않는다.
	@GetMapping("emps")
	//@ResponseBody
	public List<EmpVO> getEmpList(){
		return empService.getEmpAll();
	}
	
	//단건조회 : 단건은 조건을 받아야하기때문에 쿼리스트링으로 받지않고 경로에 붙여준다. 노드방식- :id / 스프링방식 {id}
	@GetMapping("emps/{id}")
	//@ResponseBody
	public EmpVO getEmpInfo(@PathVariable Integer id) {  //@PathVariable : 정통방식에서는 잘 사용하지않고 rest 방식에서는 자주 사용한다.
		EmpVO empVO = new EmpVO();  // info 를 받는 매개변수 id 는 그대로 넣어줄 수 없기때문에 새로운 객체를 생성하여 set에 값을 넣어줌.
		empVO.setEmployeeId(id);
		return empService.getEmpInfo(empVO);
	}
	
	//등록 : 쿼리스트링이 아닌 json 타입으로 받아 넘겨줘야함. 그 어노테이션이 @ResponseBody
	@PostMapping("emps")
	//@ResponseBody
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO){
		int eid = empService.insertEmpInfo(empVO); //@RequestBody 에 담는 작업
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", eid);
		return map; //return 타입은 어떻게 받을것인지 통일하여주는것이 좋음.
	}
	
	//수정 : 단건 + 등록 결합한 상태 / 복합적인 상태기 때문에 pathvariable을 사용해도 되고, 커맨드객체랑 request param 을 같이 혼용해도 된다.
	@PutMapping("emps/{id}")
	//@ResponseBody
	public Map<String, Object> updateEmpInfo(@PathVariable Integer id, @RequestBody EmpVO empVO){
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO); //@RequestBody 에 담는 작업

	}
	
	//삭제
	@DeleteMapping("emps/{id}")
	//@ResponseBody
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
	
	
	
	
}
