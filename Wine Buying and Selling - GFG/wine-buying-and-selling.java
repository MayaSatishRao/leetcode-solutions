//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int arr[],int N){
        // code here
        
        long res=0;
        
       /* for(int i=0;i<N;i++){
            if(arr[i]==0)
              continue;
            for(int j=0;j<N && arr[i]!=0;j++){
                if(i==j)
                  continue;
                if((arr[i]<0 && arr[j]>0) || (arr[i]>0 && arr[j]<0)){
                    int ans=arr[i]+arr[j];
                    if(Math.abs(arr[i])<=Math.abs(arr[j])){
                        res+=(Math.abs(arr[i])*Math.abs((j-i)));
                        arr[i]=0;
                        arr[j]=ans;
                    }else{
                        res+=(Math.abs(arr[j])*Math.abs((j-i)));
                        arr[j]=0;
                        arr[i]=ans;
                    }
                }
            }
        }
        
        return res;*/
        
        ArrayList<int[]> buyer = new ArrayList<>();
        ArrayList<int[]> seller = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(arr[i]<0){
                buyer.add(new int[]{Math.abs(arr[i]),i});
            }else{
                seller.add(new int[]{arr[i],i});
            }
              
        }
        
       /* Collections.sort(buyer,(a,b)->{
            return a[1]-b[1];
        });
        Collections.sort(seller,(a,b)->{
            return a[1]-b[1];
        });*/
        
        int i=0,j=0;
        while(i<buyer.size() && j<seller.size()){
            int[] b = buyer.get(i);
            int[] s = seller.get(j);
            if(b[0]<=s[0]){
                s[0]-=b[0];
                res+=b[0]*Math.abs(b[1]-s[1]);
                i++;
            }else{
                b[0]-=s[0];
                res+=s[0]*Math.abs(b[1]-s[1]);
                j++;
            }
        }
        
        return res;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends