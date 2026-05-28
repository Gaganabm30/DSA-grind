class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int res = arr[0]+arr[1]+arr[2];
        int mindif = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-2; i++){
            int j=i+1, k=arr.length-1;

          while(j<k){
            int sum = arr[i]+arr[j]+arr[k];
            if(sum<target){
                j++;
            }else if(sum>target){
                k--;
            }else{
                return target;
            }

            int todif = Math.abs(sum-target);
            if(todif<mindif){
                res=sum;
                mindif=todif;
            }
          }
        }
        return res;
    }
}