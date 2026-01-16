package com.danielbonilla.demo.service;

import com.danielbonilla.demo.dto.GradeRequest;
import com.danielbonilla.demo.dto.GradeResponse;
import com.danielbonilla.demo.model.Grade;
import com.danielbonilla.demo.model.Student;
import com.danielbonilla.demo.model.Subject;
import com.danielbonilla.demo.repository.GradeRepository;
import com.danielbonilla.demo.repository.StudentRepository;
import com.danielbonilla.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    public GradeResponse saveGrade(GradeRequest grade) {

        Student student = studentRepository.findById(grade.idStudent()).orElse(null);
        Subject subject = subjectRepository.findById(grade.idSubject()).orElse(null);
        if (student != null && subject != null) {
            Grade newGrade = new Grade();
            newGrade.setValue(grade.value());
            newGrade.setRegisterDate(grade.registerDate());
            newGrade.setStudent(student);
            newGrade.setSubject(subject);
            gradeRepository.save(newGrade);
            return GradeResponse.builder().value(newGrade.getValue())
                    .registerDate(newGrade.getRegisterDate())
                    .studentName(student.getName())
                    .subjectName(subject.getName())
                    .build();
        }
        return null;

    }

    @Transactional
    public List<GradeResponse> gradesByStudent(String name) {
        Student optionalStudent = studentRepository.findByName(name);
        List<Grade> grades = gradeRepository.findByStudent(optionalStudent);
        return grades.stream()
                .map(grade -> GradeResponse.builder()
                        .id(grade.getId())
                        .value(grade.getValue())
                        .registerDate(grade.getRegisterDate())
                        .studentName(grade.getStudent().getName())
                        .subjectName(grade.getSubject().getName())
                        .build()).toList();
    }

}
