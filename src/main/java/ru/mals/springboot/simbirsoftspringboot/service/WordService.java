package ru.mals.springboot.simbirsoftspringboot.service;

import java.util.Map;

public interface WordService {

    Map<String, Integer> parseText(String str);
    Map<String, Integer> sortResult(Map<String, Integer> countMap);
    void printResult(Object obj);
}
