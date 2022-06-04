class NumMatrix {

    int[][] arr;
    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            arr[i][0]=matrix[i][0];
            for(int j=1;j<matrix[0].length;j++)
                arr[i][j]=arr[i][j-1]+matrix[i][j];
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                arr[i][j]+=arr[i-1][j];
        }
        
        
            
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = (row1>0)?arr[row1-1][col2]:0;
        int left = (col1>0)?arr[row2][col1-1]:0;
        int repeat = (row1>0 && col1>0)?arr[row1-1][col1-1]:0;
        
        return arr[row2][col2]-(top+left-repeat);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */