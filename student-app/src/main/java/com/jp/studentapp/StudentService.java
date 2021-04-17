package com.jp.studentapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student save(Student student) {
		for(Course course: student.getCourses()) {
			course.setStudent(student);
		}
		studentRepository.save(student);
		return student;
	}
	
	public List<Student> readAll(){
		return (List<Student>) studentRepository.findAll();
	}
	
	public Student read(Integer id) {
		return studentRepository.findById(id).get();
	}
	
	public Integer delete(Integer id) {
		studentRepository.deleteById(id);
		return id;
	}
}
