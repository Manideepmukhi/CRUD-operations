package com.example.demo.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ENTITY.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
