package com.danielbonilla.demo.service;

import com.danielbonilla.demo.dto.StudentsNamesResponse;
import com.danielbonilla.demo.dto.SubjectNamesResponse;
import com.danielbonilla.demo.model.Student;
import com.danielbonilla.demo.model.Subject;
import com.danielbonilla.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<SubjectNamesResponse> findAllSubjectssNames() {
        List<Subject> subjectNamesResponse =subjectRepository.findAll();
        return subjectNamesResponse.stream()
                .map(subject -> SubjectNamesResponse.builder()
                        .subjectName(subject.getName())
                        .subjectId(subject.getId())
                        .build()).toList();
    }

    @Transactional(readOnly = true)
    public Subject getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElse(null);

    }

    @Transactional
    public Subject updateSubject(Subject subject, Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject1 = optionalSubject.get();
            subject1.setName(subject.getName());
            subject1.setCode(subject.getCode());
            subject1.setGrades(subject.getGrades());
            return subjectRepository.save(subject1);
        }
        return null;
    }

    @Transactional
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
