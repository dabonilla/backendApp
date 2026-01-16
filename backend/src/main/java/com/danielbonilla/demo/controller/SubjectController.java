package com.danielbonilla.demo.controller;

import com.danielbonilla.demo.dto.SubjectNamesResponse;
import com.danielbonilla.demo.model.Subject;
import com.danielbonilla.demo.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/addSubject")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.addSubject(subject), HttpStatus.OK);
    }

    @GetMapping("/getAllSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }

    @GetMapping("/findAllSubjectsNames")
    public ResponseEntity<List<SubjectNamesResponse>> getAllSubjectsNames() {
        return new ResponseEntity<>(subjectService.findAllSubjectssNames(), HttpStatus.OK);
    }

    @GetMapping("/getSubject/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long id) {
        Subject subject = subjectService.getSubjectById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @PutMapping("/updateSubject/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        Subject updatedSubject = subjectService.updateSubject(subject, id);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @DeleteMapping("deleteSubject/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
