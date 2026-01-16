package com.danielbonilla.demo.dto;

import lombok.Builder;

@Builder
public record SubjectNamesResponse(
        Long subjectId,
        String subjectName
) {
}
