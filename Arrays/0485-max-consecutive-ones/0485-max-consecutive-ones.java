class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int cnt=0, maxi=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1){
                cnt++;
                maxi = Math.max(cnt, maxi);
            }
            else{
                cnt=0;
            }
        }
        return maxi;
    }
}