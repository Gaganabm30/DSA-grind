class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombi(0,arr,tar, ans, new ArrayList<>());
        return ans;
    }
    private void findcombi(int ind, int []arr, int tar, List<List<Integer>> ans, List<Integer> ds){
        if(ind==arr.length){
            if(tar==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind]<=tar){
            ds.add(arr[ind]);
            findcombi(ind,arr,tar-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findcombi(ind+1, arr,tar, ans,ds);
    }
}