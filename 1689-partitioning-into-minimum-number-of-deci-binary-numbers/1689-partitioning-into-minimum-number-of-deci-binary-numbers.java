class Solution {
    public int minPartitions(String n) {
        int res=0;
        for(int i=0;i<n.length();i++){
            int num = n.charAt(i)-'0';
            res=Math.max(res,num);
        }
        return res;
    }
}