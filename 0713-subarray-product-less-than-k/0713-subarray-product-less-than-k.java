class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k<=1) return 0;

        int i=0, j=0, prod=1, cnt=0;
        while(j<arr.length){
            prod*=arr[j];
            while(prod>=k){
                prod/=arr[i];
                i++;
            }
            cnt+=(j-i+1);
            j++;
        }
        return cnt;

    }
}