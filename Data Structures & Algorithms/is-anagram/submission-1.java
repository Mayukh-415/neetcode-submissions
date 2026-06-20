class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char elem : s.toCharArray()) {
            hashMap.put(elem, hashMap.getOrDefault(elem, 0)+1);
        }

        for(char elem : t.toCharArray()) {

            if(!hashMap.containsKey(elem)) {
                return false;
            }

            hashMap.put(elem, hashMap.get(elem)-1);
        }

        for(Map.Entry<Character, Integer> e : hashMap.entrySet()){
            if(e.getValue() != 0) return false;
        }
        

        return true;
    }
}
