//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int k, int hand[]) {
        // code here
        
        if(hand.length%N!=0)
          return false;
          
         Arrays.sort(hand);
         HashMap<Integer,Integer> hm = new HashMap<>();
         
         for(int i=0;i<N;i++){
               hm.put(hand[i], hm.getOrDefault(hand[i],0)+1);
         }
         
         for(int i=0;i<N;i++){
             int f = hm.get(hand[i]),curr=hand[i];
             if(hm.get(curr)==0)
               continue;
               
             for(int j=1;j<k;j++){
                 if(hm.get(hand[i]+j)==null || hm.get(hand[i]+j)<f){
                     //System.out.println(hand[i]+" "+j);
                     return false;
                 }
                    
                 hm.put(hand[i]+j,hm.get(hand[i]+j)-f);
             }
             
             while(i<N && hand[i]==curr)
               i++;
             i--;
         }
         
         return true;
            
        
    }
}
