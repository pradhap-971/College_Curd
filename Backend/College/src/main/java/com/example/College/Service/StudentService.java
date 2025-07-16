package com.example.College.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.College.Repo.StudentRepository;
import com.example.College.model.Student;

@Service
public class StudentService {
	
	 @Autowired
	    private StudentRepository repo;

	    public Student save(Student student) {
	        return repo.save(student);
	    }

	    public List<Student> getAll() {
	        return repo.findAll();
	    }

	    public Student getById(int id) {
	        return repo.findById(id).orElse(null);
	    }

	    public Student update(int id, Student updatedStudent) {
	        Student student = repo.findById(id).orElse(null);
	        if (student != null) {
	            student.setName(updatedStudent.getName());
	            student.setDepartment(updatedStudent.getDepartment());
	            student.setEmail(updatedStudent.getEmail());
	            return repo.save(student);
	        }
	        return null;
	    }

	    public void delete(int id) {
	        repo.deleteById(id);
	    }

}
