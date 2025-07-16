package com.example.College.Controller;

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

import com.example.College.Service.StudentService;
import com.example.College.model.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin("http://localhost:3000")  
public class StudentController {

	 @Autowired
	    private StudentService service;

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return service.save(student);
	    }

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return service.getAll();
	    }

	    @GetMapping("/{id}")
	    public Student getStudentById(@PathVariable int id) {
	        return service.getById(id);
	    }

	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
	        return service.update(id, student);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteStudent(@PathVariable int id) {
	        service.delete(id);
	    }
	
	
	
}
