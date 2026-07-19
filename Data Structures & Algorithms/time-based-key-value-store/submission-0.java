class Pair{

    String val;
    int timestamp;

    Pair(int timestamp,String val){
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    Map<String,ArrayList<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        
        if(!mp.containsKey(key)){
            return "";
        }
        else{

            List<Pair> list = mp.get(key);
            int start = 0;
            int end = list.size()-1;
            String ans = "";
            while(start<=end){

                int mid = (start+end)/2;
                if(list.get(mid).timestamp == timestamp)
                    return list.get(mid).val;
                
                if(list.get(mid).timestamp < timestamp){
                    ans = list.get(mid).val;
                    start = mid+1;
                }
                else
                    end = mid-1;
            }
            return ans;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */