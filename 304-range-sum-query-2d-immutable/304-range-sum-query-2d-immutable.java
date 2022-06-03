class NumMatrix {

    int[][] arr;
    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                arr[i][j]=matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++)
            for(int j=col1;j<=col2;j++)
                sum+=arr[i][j];
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */