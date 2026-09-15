class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int end=-1;
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(max>arr[i]){
                end=i;
            }else{
                max=arr[i];
            }
        }

        int start=0;
        int min = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            if(min<arr[i]){
                start=i;
            }else{
                min=arr[i];
            }
        }
        return end-start+1;
    }
}