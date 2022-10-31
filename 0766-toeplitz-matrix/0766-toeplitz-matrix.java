class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            int prev = matrix[i][0],j=1, temp=i+1;
            while(temp<m && j<n){
                if(prev!=matrix[temp][j])
                    return false;
                 temp++;
                 j++;
            }
        }
        
        for(int i=0;i<n;i++){
            int prev = matrix[0][i], j=1, temp=i+1;
            while(j<m && temp<n){
                if(prev!=matrix[j][temp])
                    return false;
                temp++;
                j++;
            }
        }
        
        return true;
    }
}