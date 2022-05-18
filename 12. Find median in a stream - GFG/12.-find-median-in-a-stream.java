// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    public static PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder());
    public static PriorityQueue<Integer> larger = new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        // add your code here
        if(smaller.size()==0){
            smaller.add(x);
            return ;
        }
        if(larger.size()==0){
            if(x>=smaller.peek())
            larger.add(x);
            else{
                larger.add(smaller.poll());
                smaller.add(x);
            }
            return ;
        }
        
        if(smaller.size()==larger.size()){
            if(x<=larger.peek())
            smaller.add(x);
            else{
                smaller.add(larger.poll());
                larger.add(x);
            }
        }else{
            if(x>=smaller.peek())
            larger.add(x);
            else{
                larger.add(smaller.poll());
                smaller.add(x);
            }
        }
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(smaller.size()==larger.size()){
            return ((double)smaller.peek()+(double)larger.peek())/(double)2;
        }
        
        return (double)smaller.peek();
    }
    
}