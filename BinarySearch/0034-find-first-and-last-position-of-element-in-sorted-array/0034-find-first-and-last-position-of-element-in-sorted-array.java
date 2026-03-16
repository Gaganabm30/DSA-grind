class Solution {
    public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1};
            int start = firstSearch(nums, target);
            int end = secondSearch(nums, target);
            
            return new int[]  {start, end}; 
   }

    static int firstSearch(int[] arr, int target){
        int ans = -1; 
        int start = 0; 
        int end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target==arr[mid]){
                ans = mid;
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                end= mid-1;
            }
        }
        return ans;
    }

    static int secondSearch(int[] arr, int target){
        int ans = -1;
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target==arr[mid]){
                ans=mid;
                start  = mid+1;
            }else if(target>arr[mid]){
               start  = mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }

}