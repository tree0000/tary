package org.doit.ik;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class ScottRestController {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@PostMapping("scott/dept/new")
	public  ResponseEntity insertDept(@RequestBody DeptDTO dto){
		log.info(" >ScottRestController.insertDept()...");
		int insertResult = this.deptMapper.insertDept(dto);
		
		return insertResult == 1 	
				? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	
}
