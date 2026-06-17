class Solution {
    public int majorityElement(int[] arr) {
        int el = 0, cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(cnt == 0){
                el=arr[i];
            }
            if(el==arr[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return el;
    }
}