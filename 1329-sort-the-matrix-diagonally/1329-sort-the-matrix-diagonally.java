class Solution {
    
    public void countingSort(int[][] arr, int r, int c){
          int m = arr.length, n= arr[0].length;
          int[] freq = new int[101];
          int i=r,j=c,count=0;
        
          while(i<m && j<n){
              freq[arr[i][j]]++;
              i++;
              j++;
              count++;
          }
        
          for(i=1;i<101;i++)
              freq[i]=freq[i]+freq[i-1];
        
        i=r;j=c;
        int[] temp = new int[count];
        while(i<m && j<n){
            int in = freq[arr[i][j]]-1;
            i++;
            j++;
            temp[in]=arr[i][j];
        }
        
        i=r;
        j=c;
        count=0;
        while(i<m && j<n){
            arr[i][j]=temp[count];
            i++;
            j++;
            count++;
        }

    }
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
                    visit[k][l]=true;
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