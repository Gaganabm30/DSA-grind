class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int posind = 0;
        int negind = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                ans[posind] = arr[i];
                posind+=2;
            }
            else{
                ans[negind] = arr[i];
                negind+=2;
            }
        }
        return ans;
    }
}