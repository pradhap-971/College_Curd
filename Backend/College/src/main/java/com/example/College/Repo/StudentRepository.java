package com.example.College.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.College.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student save(Student student);
	
	
	

}
