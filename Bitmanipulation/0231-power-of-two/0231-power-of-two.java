class Solution {
    public boolean isPowerOfTwo(int n) {
        // boolean isPower=false;
        // for(int i=0;i<n;i++){
        //     if(n==Math.pow(2,i)){
        //     isPower=true;
        //     break;
        //     }
        // }
        return n>0 && (n &(n-1))==0;
    }
}