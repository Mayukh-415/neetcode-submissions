
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            // Count frequency of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Create a unique string key from the frequency array
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#'); // Separator to prevent collisions
                sb.append(i);
            }
            String key = sb.toString();

            // Group the strings
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}