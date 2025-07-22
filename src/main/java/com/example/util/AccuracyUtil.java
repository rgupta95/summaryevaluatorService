package com.example.util;

import java.util.*;

public class AccuracyUtil {

    public static double calculateCosineSimilarity(String text1, String text2) {
        Map<String, Integer> freq1 = getTermFrequency(text1);
        Map<String, Integer> freq2 = getTermFrequency(text2);

        Set<String> allWords = new HashSet<>(freq1.keySet());
        allWords.addAll(freq2.keySet());

        int[] v1 = new int[allWords.size()];
        int[] v2 = new int[allWords.size()];

        int i = 0;
        for (String word : allWords) {
            v1[i] = freq1.getOrDefault(word, 0);
            v2[i] = freq2.getOrDefault(word, 0);
            i++;
        }

        return cosine(v1, v2);
    }

    private static Map<String, Integer> getTermFrequency(String text) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.toLowerCase().split("\\W+")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    private static double cosine(int[] a, int[] b) {
        double dot = 0.0, normA = 0.0, normB = 0.0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            normA += Math.pow(a[i], 2);
            normB += Math.pow(b[i], 2);
        }
        return (normA == 0 || normB == 0) ? 0.0 : dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
