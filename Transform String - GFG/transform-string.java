// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        int[] alp1 = new int[256];
        int[] alp2 = new int[256];
        
        if(A.length()!=B.length())
        return -1;
        for(int i=0;i<A.length();i++){
            alp1[A.charAt(i)]++;
            alp2[B.charAt(i)]++;
        }
        
        for(int i=0;i<256;i++)
        if(alp1[i]!=alp2[i])
        return -1;
        
        int count=0,i=A.length()-1,j=B.length()-1;
        while(i>=0 && j>=0){
            if(A.charAt(i)==B.charAt(j)){
                i--;
                j--;
            }else{
                while(i>=0 && A.charAt(i)!=B.charAt(j)){
                    i--;
                    count++;
                }
            }
        }
        
        return count;
    }
}