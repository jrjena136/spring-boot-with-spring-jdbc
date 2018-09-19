package com.jyoti.dev.springjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyoti.dev.springjdbc.dao.ApiRepository;
import com.jyoti.dev.springjdbc.model.ApiModel;
import com.jyoti.dev.springjdbc.model.CustomerInfo;

@RestController
@RequestMapping("/spring-boot-with-spring-jdbc")
@ComponentScan(basePackages="{com.jyoti.dev.springjdbc}")
public class ApiController {
	@Autowired
	private ApiRepository repository;
	
	/*@Autowired
    private DataSource dataSource;*/
	
	@GetMapping("/findApi")
	public List<ApiModel> getAllApiInfo() {
		return repository.findAll();
		
	}
	
	@PostMapping("/customer-registration")
	public Map<String,Object> getProcResponse(@RequestBody CustomerInfo customerInfo){
		return repository.doCustomerRegistration(customerInfo);
	}

}
