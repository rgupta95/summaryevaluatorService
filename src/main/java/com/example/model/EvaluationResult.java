package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalText;

    @Column(columnDefinition = "TEXT")
    private String generatedSummary;

    @Column(columnDefinition = "TEXT")
    private String referenceSummary;

    private double accuracyScore;

    private String methodUsed;
}
