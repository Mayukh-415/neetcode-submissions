class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        int[] pref = new int [nums.length];
        int[] suff = new int [nums.length];

        
        pref[0]= 1;
        
        for(int i = 1; i<nums.length; i++){
            pref[i] = nums[i-1] * pref[i-1]; 
        }
        
        //  for(int num : pref) System.out.print(num + " ");
        //  System.out.println("");
        
        suff[nums.length-1] = 1;
        
        for(int i = nums.length -2 ; i>=0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }
        
        //  for(int num : suff) System.out.print(num + " ");
        //  System.out.println("");
        
        int idx = 0;
        int[] ans = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            // System.out.println("pref[i]" + pref[i]);
            // System.out.println("suff[i]" + suff[i]);
            ans[i] = pref[i]*suff[i];
        }

        return ans;
    }
}  
