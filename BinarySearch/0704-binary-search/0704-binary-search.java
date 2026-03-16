class Solution {
    public int search(int[] nums, int target) {
       return  help(nums,target,0,nums.length-1);
        // int n = nums.length;
        // int lo = 0;
        // int hi = n-1;
        // int idx = -1;

        // while(lo<=hi){
        //     int mid = (lo+hi)/2;
        //     if(nums[mid]>target)hi = mid-1;
        //     else if(nums[mid]<target)lo = mid+1;
        //     else{
        //         idx = mid;
        //         hi = mid-1;
        //     }
        // }
        // return idx;
    }
    public static int help(int [] arr, int tar, int lo, int hi){
        if(lo>hi)return -1;
        int mid = lo+(hi-lo)/2;
        if(arr[mid] == tar)return mid;
        else if(arr[mid] >tar)return help( arr,  tar,  lo,  mid-1);
        else return  help(arr,  tar,  mid+1,  hi);
    }
}