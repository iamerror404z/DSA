import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph
                .toLowerCase()
                .replaceAll("[^a-z ]", " ")
                .split("\\s+");

        String result = "";
        int max = 0;

        for (String w : words) {
            if (w.length() == 0 || bannedSet.contains(w)) continue;

            count.put(w, count.getOrDefault(w, 0) + 1);

            if (count.get(w) > max) {
                max = count.get(w);
                result = w;
            }
        }

        return result;
    }
}