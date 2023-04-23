//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimumNumber(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumNumber(int n, int[] arr) {
        // code here
       /* PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
          pq.add(arr[i]);
        
        while(pq.size()>1){
            int a = pq.poll(), b=pq.poll();
            if(b==0){
                pq.add(a);
                break;
            }
              
            pq.add(b);
            pq.add(a-b);
            
        }
        
        return pq.peek();*/
        int even=0, min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
          if(arr[i]%2==0){
              even++;
              double fact = (Math.log(arr[i])/Math.log(2));
              min = Math.min((int)fact,min);
          }
            
       
       if(even==n)
         return (int)Math.pow(2,min);
    
       return 1;
    }
}
        
