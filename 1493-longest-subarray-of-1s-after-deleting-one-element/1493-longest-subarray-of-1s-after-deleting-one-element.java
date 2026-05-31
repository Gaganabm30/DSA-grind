class Solution {
    public int longestSubarray(int[] arr) {
        int i=0, zero=0, maxLen=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j]==0){
                zero++;
            }
            while(zero>1){
               if(arr[i]==0){
                  zero--;
                }
                  i++;
            }
            maxLen=Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}