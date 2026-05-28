class Solution {
    public int[] sortedSquares(int[] arr) {
        int[] res = new int[arr.length];
        int i=0, j=arr.length-1;

        for(int k=arr.length-1; k>=0; k--){
             if (Math.abs(arr[i]) > Math.abs(arr[j])){
                res[k] = arr[i] * arr[i];
                i++;
            }else{
                res[k] = arr[j] * arr[j];
                j--;
            }
        }       
        return res;
    }
}