// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


 // } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        HashMap<Integer,Integer>pos = new HashMap<Integer,Integer>();
        for(int i=0;i<M;i++){
            if(pos.get(A2[i])==null)
            pos.put(A2[i],i);
        }
        
        ArrayList<Integer>p = new ArrayList<>();
        ArrayList<Integer>np = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            if(pos.get(A1[i])==null)
            np.add(A1[i]);
            else
            p.add(A1[i]);
        }
        
        Collections.sort(np);
        Collections.sort(p,(a,b)-> pos.get(a)-pos.get(b));
        
        int[] res = new int[N];
        for(int i=0;i<p.size();i++)
        res[i]=p.get(i);
        
        for(int i=0;i<np.size();i++)
        res[i+p.size()]=np.get(i);
        
        return res;
    }
}



// { Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}


  // } Driver Code Ends