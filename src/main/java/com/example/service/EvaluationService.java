package com.example.service;

import com.example.dto.EvaluationRequest;
import com.example.model.EvaluationResult;
import com.example.repository.EvaluationResultRepository;
import com.example.util.AccuracyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationResultRepository repository;

    public EvaluationResult evaluateSummary(EvaluationRequest request) {
        double score = AccuracyUtil.calculateCosineSimilarity(request.getGeneratedSummary(), request.getReferenceSummary());

        EvaluationResult result = EvaluationResult.builder()
                .originalText(request.getOriginalText())
                .generatedSummary(request.getGeneratedSummary())
                .referenceSummary(request.getReferenceSummary())
                .accuracyScore(score)
                .methodUsed("CosineSimilarity")
                .build();

        return repository.save(result);
    }
}
