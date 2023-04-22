//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int binarySearch(int[] arr, int key){
        int i=0,j=arr.length-1;
        int res=-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]==key){
                res=mid;
                j=mid-1;
            }
            else if(arr[mid]<key)
              i=mid+1;
            else
              j=mid-1;
        }
        
        return res;
    }
    public long[] smallerSum(int n,int arr[])
    {
        int[] temp = new int[n];
        for(int i=0;i<n;i++)
          temp[i] = arr[i];
        
        Arrays.sort(temp);
        long[] pre = new long[n];
        pre[0] = temp[0];
        for(int i=1;i<n;i++)
          pre[i]=pre[i-1]+temp[i];
        
        long[] ans = new long[n];
        //System.out.println(Arrays.toString(temp));
        
        for(int i=0;i<n;i++){
            int ind = binarySearch(temp,arr[i]);
            //System.out.println(ind);
            if(ind<=0)
              ans[i]=0;
            else
              ans[i]=pre[ind-1];
        }
        
        return ans;
    }
}