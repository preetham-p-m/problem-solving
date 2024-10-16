package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int wordLength = words[0].length();
        int windowSize = wordLength * words.length;

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i <= s.length() - windowSize; i++) {
            var innerMap = new HashMap<>(map);

            for (int j = i; j < i + windowSize; j = j + wordLength) {
                String subString = s.substring(j, j + wordLength);
                if (innerMap.containsKey(subString)) {
                    innerMap.put(subString, innerMap.get(subString) - 1);
                    if (innerMap.get(subString) == 0) {
                        innerMap.remove(subString);
                    }
                } else {
                    break;
                }

            }

            if (innerMap.isEmpty()) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> findSubstringOptimized(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<Integer> ansList = new ArrayList<>();

        int wordSize = words[0].length();
        int numberOfWords = words.length;

        for (int i = 0; i < wordSize; i++) {
            Map<String, Integer> innerMap = new HashMap<>();
            int count = 0;
            for (int j = i, k = i; j + wordSize <= s.length(); j += wordSize) {

                String string = s.substring(j, j + wordSize);
                innerMap.put(string, innerMap.getOrDefault(string, 0) + 1);
                count++;

                if (count == numberOfWords) {
                    if (map.equals(innerMap)) {
                        ansList.add(k);
                    }
                    String remove = s.substring(k, k + wordSize);
                    innerMap.computeIfPresent(remove, (a, b) -> b > 1 ? b - 1 : null);
                    count--;
                    k = k + wordSize;
                }

            }
        }

        return ansList;
    }

}
