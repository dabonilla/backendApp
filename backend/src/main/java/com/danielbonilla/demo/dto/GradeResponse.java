package com.danielbonilla.demo.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GradeResponse(
        Long id,
        int value,
        LocalDate registerDate,
        String studentName,
        String subjectName
) {
}
