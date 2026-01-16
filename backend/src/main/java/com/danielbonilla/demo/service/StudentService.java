package com.danielbonilla.demo.service;

import com.danielbonilla.demo.dto.StudentsNamesResponse;
import com.danielbonilla.demo.model.Student;
import com.danielbonilla.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<StudentsNamesResponse> findAllStudentsNames() {
        List<Student> studentResponses =studentRepository.findAll();
        return studentResponses.stream()
                .map(student -> StudentsNamesResponse.builder()
                        .studentName(student.getName())
                        .studentId(student.getId())
                        .build()).toList();
    }

    @Transactional(readOnly = true)
    public Student findStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Transactional
    public Student updateStudent(Student student, Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student updatedStudent = optionalStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setDateOfBirth(student.getDateOfBirth());
            return studentRepository.save(updatedStudent);
        }
        return null;

    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
