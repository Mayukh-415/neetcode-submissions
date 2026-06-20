class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> listVector = new HashMap<>();

        for (String elem : strs) {
            // 1. Convert string to char array
            char[] charArray = elem.toCharArray();
            // 2. Sort it (modifies in place)
            Arrays.sort(charArray);
            // 3. Convert back to string to use as a key
            String tempStr = new String(charArray);

            // 4. Use computeIfAbsent to initialize the list and add the word
            listVector.computeIfAbsent(tempStr, k -> new ArrayList<>()).add(elem);
        }

        // Return the values (the groups) as a List
        return new ArrayList<>(listVector.values());
    }
}