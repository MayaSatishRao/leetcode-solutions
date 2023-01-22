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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static ArrayList<Integer> factors(int n){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                arr.add(i);
                arr.add((n/i));
            }
        }
        return arr;
    }
    public static int solve(int N, int K, int[] arr) {
        // code here
        int sum = arr[0];
        for(int i=1;i<N;i++){
            sum+=arr[i];
            arr[i]+=arr[i-1];
        }
        
        ArrayList<Integer> fact = factors(sum);
        int res=-1;
        
        for(int i=0;i<fact.size();i++){
            int a = fact.get(i);
            int count=0;
            for(int j=0;j<N;j++){
                if(arr[j]%a==0)
                  count++;
            }
            if(count>=K)
              res=Math.max(res,a);
        }
        
        return res;
    }
}
        
