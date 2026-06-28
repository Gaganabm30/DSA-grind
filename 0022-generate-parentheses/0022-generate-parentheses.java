class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       addPar(0,0,"",res,n);
       return res;
    }
    private void addPar(int open, int close, String s, List<String> res, int n){
        if(open==close && open+close==2*n){
            res.add(s);
            return;
        }

        if(open<n){
            addPar(open+1, close, s+"(", res, n);
        }
        
        if(open>close){
            addPar(open, close+1, s+")", res, n);
        }
    }
}