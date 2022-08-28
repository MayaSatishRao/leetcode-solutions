class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n= mat[0].length;
        boolean[][] visit = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j])
                    continue;
                
                int k=i,l=j,index=0;
                ArrayList<Integer> arr = new ArrayList<Integer>();
                while(k<m && l<n){
                    arr.add(mat[k][l]);
                    k++;
                    l++;
                }
                
                Collections.sort(arr);
                k=i;
                l=j;
                while(k<m && l<n){
                    mat[k][l]=arr.get(index);
                    k++;
                    l++;
                    index++;
                }
                
            }
        }
        
        return mat;
    }
}