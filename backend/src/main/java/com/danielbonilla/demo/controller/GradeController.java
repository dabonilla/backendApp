package com.danielbonilla.demo.controller;

import com.danielbonilla.demo.dto.GradeRequest;
import com.danielbonilla.demo.dto.GradeResponse;
import com.danielbonilla.demo.model.Grade;
import com.danielbonilla.demo.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/addGrade")
    public ResponseEntity<GradeResponse> addGrade(@RequestBody GradeRequest gradeRequest) {
        GradeResponse newGrade = gradeService.saveGrade(gradeRequest);
        return new ResponseEntity<>(newGrade, HttpStatus.OK);
    }

    @GetMapping("/getGrade/{name}")
    public ResponseEntity<List<GradeResponse>> getGrade(@PathVariable String name) {
        List<GradeResponse> listGrades = gradeService.gradesByStudent(name);
        return new ResponseEntity<>(listGrades, HttpStatus.OK);
    }

}
