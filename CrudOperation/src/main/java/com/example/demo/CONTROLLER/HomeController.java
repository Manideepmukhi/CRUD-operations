package com.example.demo.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ENTITY.Student;
import com.example.demo.REPOSITORY.StudentRepository;

@RestController
public class HomeController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String index()
	{
		return "Welcome to spring boot";
		
	}
	@PostMapping("/saveStudent")
	public Student saveData(@RequestBody Student student)
	{
		studentRepository.save(student);
		return student;
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAll(){
		List<Student> studentList=studentRepository.findAll();
		return studentList;
		}
	
	@DeleteMapping("/deleteStudent/{rollno}")
	public String deleteStudent(@PathVariable int rollno)
	{
		Student student =studentRepository.findById(rollno).get();
		if(student!=null)
		{
			studentRepository.delete(student);
			
		}
		return "Deleted";
	}
	
	@PutMapping("/updateData")
	public Student updateStudentData(@RequestBody Student student)
	{
		studentRepository.save(student);
		return student;
	}
	

}
