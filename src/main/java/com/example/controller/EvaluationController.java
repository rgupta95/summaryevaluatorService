package com.example.controller;

import com.example.dto.EvaluationRequest;
import com.example.model.EvaluationResult;
import com.example.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluate")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping
    public EvaluationResult evaluate(@RequestBody EvaluationRequest request) {
        return evaluationService.evaluateSummary(request);
    }
}
