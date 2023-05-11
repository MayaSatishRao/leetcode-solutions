//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        // code here
        char[] arr = s.toCharArray();
        boolean pal = true;
        int i=0, j=s.length()-1;
        
        while(i<j){
            if(arr[i]!='?' && arr[j]=='?')
              arr[j]=arr[i];
            else if(arr[i]=='?' && arr[j]!='?')
              arr[i] = arr[j];
            else if(arr[i]!='?' && arr[j]!='?' && arr[i]!=arr[j])
               pal=false;
            i++;
            j--;
        }
        
        if(!pal)
          return -1;
        
        char prev = '?';
        int res=0;
        i=0;
        while(i<s.length()){
            while(i<s.length() && arr[i]=='?')
              i++;
            if(prev!='?' && i<s.length()){
                res+=Math.abs(prev-arr[i]);
            }
            if(i<s.length())
              prev=arr[i];
            i++;
        }
        
        return res;
    }
}
