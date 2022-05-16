// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java
class Element{
    int el;
    int arr_in;
    int el_in;

    public Element(int a, int b, int c){
        el=a;
        arr_in=b;
        el_in=c;
    }
}

class Solution
{
    
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
         ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<Element>((Element a, Element b)->a.el-b.el);

        for(int i=0;i<arr.length;i++){
            pq.add(new Element(arr[i][0],i,0));
        }

        while(!pq.isEmpty()){
            Element p = pq.poll();
            int arr_index = p.arr_in;
            int el_index = p.el_in;

            res.add(p.el);
            if(el_index<arr[arr_index].length-1)
                pq.add(new Element(arr[arr_index][el_index+1],arr_index,el_index+1));
        }

        return res;
        
    }
}