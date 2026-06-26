class Solution {
    public int[] searchRange(int[] arr, int target) {
            int[] ans = {-1,-1};
            int first=firstOcc(arr,target);
            int last=lastOcc(arr,target);
            return new int[] {first, last};
   }
    private int firstOcc(int[] arr, int target){
        int low=0, high=arr.length-1, ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private int lastOcc(int[] arr, int target){
         int low=0, high=arr.length-1, ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}