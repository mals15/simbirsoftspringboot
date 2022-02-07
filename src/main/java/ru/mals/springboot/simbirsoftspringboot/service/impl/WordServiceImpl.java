package ru.mals.springboot.simbirsoftspringboot.service.impl;

import org.springframework.stereotype.Service;
import ru.mals.springboot.simbirsoftspringboot.service.WordService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    String [] words;
    Map<String, Integer> countMap = new HashMap<>();
    
    @Override
    public Map<String, Integer> parseText(String str) {
        words = str.split("[)(}{\\[\\].,\\s\\n\\t\\r!;?:\"'—-]+");
        for (String s:words) {
            if (!countMap.containsKey(s)) {
                countMap.put(s, 1);
            } else {
                countMap.put(s, countMap.get(s) + 1);
            }
        }
        return countMap;
    }

    public Map<String, Integer> sortResult(Map<String, Integer> countMap) {
        countMap =  countMap.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        return countMap;
    }

    public void printResult(Object obj) {

    }
}
