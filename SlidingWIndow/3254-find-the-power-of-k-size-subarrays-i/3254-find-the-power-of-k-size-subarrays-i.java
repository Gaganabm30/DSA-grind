class Solution {
    public int[] resultsArray(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int len=1;

        for(int i=1; i<n; i++){
            if(arr[i]==arr[i-1]+1){
                len++;
            }else{
                len=1;
            }

            if(i>=k-1){
                if(len>=k){
                    ans[i-k+1]=arr[i];
                }else{
                    ans[i-k+1]=-1;
                }
            }
        }
        if(k==1){
            for(int i=0; i<n; i++){
                 ans[i]=arr[i];
            }  
        }
        return ans;
    }
}