package com.danielbonilla.demo.dto;

import lombok.Builder;

@Builder
public record StudentsNamesResponse(
        Long studentId,
        String studentName
) {
}
