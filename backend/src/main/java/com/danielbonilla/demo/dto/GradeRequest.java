package com.danielbonilla.demo.dto;

import java.time.LocalDate;

public record GradeRequest(
        int value,
        LocalDate registerDate,
        Long idStudent,
        Long idSubject
) {
}
