//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder(arr[i]).reverse();
            String rev = str.toString();
            hm.put(rev,hm.getOrDefault(rev,0)+1);
        }
        
        boolean odd = arr.length%2==1;
        int o=0;
        
        for(int i=0;i<n;i++){
            
            if(hm.containsKey(arr[i]) && hm.get(arr[i])>0){
                hm.put(arr[i],hm.get(arr[i])-1);
                continue;
            }else{
              return false;
            }
        }
          
            
        
        return true;
    }
}
        
