public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int counter = t.length();
        int i = 0, j = 0;
        char[] str = s.toCharArray();
        int minWindow = Integer.MAX_VALUE;
        int bestStart = 0;

        while (j < str.length) {
            if (map.containsKey(str[j]) && map.get(str[j]) > 0) {
                counter--;
                map.put(str[j], map.get(str[j]) - 1);

            } else {
                if (map.containsKey(str[j])) {
                    map.put(str[j], map.get(str[j]) - 1);
                } else {
                    map.put(str[j], 0);
                    map.put(str[j], map.get(str[j]) - 1);
                }
            }

            if (counter == 0) {
                while (counter == 0) {
                    if (j - i + 1 < minWindow) {
                        minWindow = j - i + 1;
                        bestStart = i;
                    }

                    map.put(str[i], map.get(str[i]) + 1);
                    if (map.get(str[i]) > 0) {
                        counter++;
                    }
                    i++;
                }
            }
            j++;
        }
        if (minWindow == Integer.MAX_VALUE)
            return "";

        return String.valueOf(str, bestStart, minWindow);
    }
}