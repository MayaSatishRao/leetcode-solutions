//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
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
    public boolean findLeaf(int[] arr, int lowerBound, int upperBound, int index[], ArrayList<Integer> res){
        if(index[0]>=arr.length || arr[index[0]]>upperBound || arr[index[0]]<lowerBound)
        return false;
        
        int val = arr[index[0]++];
       
        boolean b = findLeaf(arr,lowerBound,val,index,res);
         boolean a = findLeaf(arr,val,upperBound,index,res);
        
        if(!a && !b){
            res.add(val);
        }
        
        
        return true;
    }
    public int[] leafNodes(int arr[], int n)
    {
        // code here
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        findLeaf(arr,Integer.MIN_VALUE,Integer.MAX_VALUE,new int[]{0}, res);
        
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++)
        ans[i]=res.get(i);
        
        return ans;
    }
}