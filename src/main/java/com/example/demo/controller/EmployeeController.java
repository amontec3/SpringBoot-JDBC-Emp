package com.example.demo.controller;

//public class EmployeeController {
//
//}

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	public List<Employee> getAll() {
		return repo.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	public Employee getOne(@PathVariable int id) {
		return repo.fineOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public Object addOne(@RequestBody Employee employee) {
		return repo.addOne(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public int deleteOne(@RequestBody Employee employee, @PathVariable int id) {
		return repo.UpdateOne(employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public int deleteOne(@PathVariable int id) {
		return repo.deleteOne(id);
	}

}

