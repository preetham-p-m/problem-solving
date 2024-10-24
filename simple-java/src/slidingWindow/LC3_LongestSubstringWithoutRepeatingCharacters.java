package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0, right = 0;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }

            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
