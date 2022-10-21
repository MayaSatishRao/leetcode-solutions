//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
        int topRow = 0, bottomRow=R-1, leftCol=0, rightCol=C-1,index=R*C-1;
        int[] res = new int[R*C];
        
        while(index>=0){
            for(int i=leftCol;i<=rightCol;i++)
             res[index--]=a[topRow][i];
             topRow++;
             
             if(index<0)
             break;
             
             for(int i=topRow;i<=bottomRow;i++)
             res[index--]=a[i][rightCol];
             rightCol--;
             
             if(index<0)
             break;
             
             for(int i=rightCol;i>=leftCol;i--)
             res[index--]=a[bottomRow][i];
             bottomRow--;
             
             if(index<0)
             break;
             
             for(int i=bottomRow;i>=topRow;i--)
             res[index--]=a[i][leftCol];
             leftCol++;
             
             
        }
        
        return res;
    }
}