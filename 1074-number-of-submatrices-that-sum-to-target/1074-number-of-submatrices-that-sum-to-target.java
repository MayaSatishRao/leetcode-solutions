class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++)
                matrix[i][j]+=matrix[i][j-1];
        }
        
        int count=0;
        for(int start = 0;start<m;start++){
            for(int end=start;end<m;end++){
                HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
                hm.put(0,1);
                
                int sum=0;
                for(int i=0;i<n;i++){
                    sum += matrix[i][end] - (start>0?matrix[i][start-1]:0);
                    count += hm.getOrDefault(sum-target,0);
                    hm.put(sum,hm.getOrDefault(sum,0)+1);
                }
            }
        }
        
        return count;
    }
}
