package com.jp.studentapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@GetMapping
	public List<Student> readAll(){
		return studentService.readAll();
	}
	
	@GetMapping("/{id}")
	public Student read(@PathVariable Integer id) {
		return studentService.read(id);
	}
	
	@DeleteMapping("/{id}")
	public Integer delete(@PathVariable Integer id) {
		return studentService.delete(id);
	}
	
	@PutMapping
	public Student update(@RequestBody Student student) {
		return studentService.save(student);
	}
}
