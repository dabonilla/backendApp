package com.danielbonilla.demo.repository;

import com.danielbonilla.demo.model.Grade;
import com.danielbonilla.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudent(Student student);
}
