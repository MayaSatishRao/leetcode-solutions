//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    
    public static boolean intersecting(int[] a, int[] b){
        if(b[0]<=a[1] && b[1]>=a[0])
           return true;
        return false;
    }
    
    public static int binarySearch(int[] arr, int key){
        int low=0, high=arr.length-1;
        int res=-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr[mid]>=key){
                res=mid;
                high=mid-1;
            }else
              low=mid+1;
            //System.out.println(arr[mid]+" "+res+" "+key);
        }
        
        return res;
    }
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        Arrays.sort(range,(a,b)->{
            if(a[0]==b[0])
              return a[1]-b[1];
            return a[0]-b[0];
        });
        
        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            
            stk.push(range[i]);
            
            while(stk.size()>=2){
                int[] p = stk.pop();
                int[] r = stk.pop();
                if(intersecting(p,r)){
                    int[] ne = {Math.min(p[0],r[0]),Math.max(p[1],r[1])};
                    stk.push(ne);
                }else{
                    stk.push(r);
                    stk.push(p);
                    break;
                }
            }
        }
        
        
        ArrayList<int[]> arr = new ArrayList<>();
        while(!stk.isEmpty())
          arr.add(stk.pop());
          int s = arr.size();
        //System.out.println(arr.get(0)[0]+" "+arr.get(0)[1]);
        Collections.reverse(arr);
        int[] sizes = new int[s];
        sizes[0] = arr.get(0)[1]-arr.get(0)[0]+1;
        
        for(int i=1;i<s;i++)
          sizes[i] = sizes[i-1]+arr.get(i)[1]-arr.get(i)[0]+1;
        
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<q;i++){
            int index = binarySearch(sizes,queries[i]);
            if(index==-1)
              res.add(-1);
            else{
                int prev = (index==0)?0:sizes[index-1];
                int offset = queries[i]-prev-1;
                res.add(arr.get(index)[0]+offset);
            }
        }
        
        return res;
    }
}
        
