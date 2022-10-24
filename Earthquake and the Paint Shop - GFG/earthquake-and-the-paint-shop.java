//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s[] = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric ans[] = ob.sortedStrings(N, s);
            for (int i = 0; i < ans.length; i++)
                System.out.println(ans[i].name + " " + ans[i].count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};
class Solution {
    alphanumeric[] sortedStrings(int N, String A[]) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<N;i++){
            if(hm.get(A[i])==null)
            hm.put(A[i],1);
            else
            hm.put(A[i],hm.get(A[i])+1);
        }
        
        alphanumeric[] arr = new alphanumeric[hm.size()];
        Iterator itr = hm.entrySet().iterator();
        int index=0;
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry)itr.next();
            String a = (String)me.getKey();
            int freq = (int)me.getValue();
            arr[index++]=new alphanumeric(a,freq);
        }
        
        Arrays.sort(arr,(a,b)->{
           
              return a.name.compareTo(b.name);

        });
        
        return arr;
    }
};