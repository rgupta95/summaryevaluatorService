package com.example.dto;

import lombok.Data;

@Data
public class EvaluationRequest {
    private String originalText;
    private String generatedSummary;
    private String referenceSummary;
}
