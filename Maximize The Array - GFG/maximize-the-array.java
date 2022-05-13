// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    void mergeSorted(int[] res, HashMap<Integer, Integer> arr,int start, int mid,int end){
        int n1 = mid-start+1, n2 = end-mid;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0;i<n1;i++)
        left[i]=res[start+i];
        
        for(int i=0;i<n2;i++)
        right[i]=res[mid+1+i];
        
        int i=0,j=0,k=start;
        while(i<n1 && j<n2){
            int a = arr.get(left[i]);
            int b = arr.get(right[j]);
          //  System.out.println(Arrays.toString(arr));
           // System.out.println(a+" "+left[i]+" "+b+" "+right[j]);
            if(a<b){
                res[k++]=left[i++];
            }else
                res[k++]=right[j++];
        }
        
        while(i<n1)
        res[k++]=left[i++];
        
        while(j<n2)
        res[k++]=right[j++];
        
        
    }
    void sortArray(int[] res, HashMap<Integer, Integer> arr, int start, int end){
        if(start<end){
            int mid = start+(end-start)/2;
            sortArray(res,arr,start,mid);
            sortArray(res,arr,mid+1,end);
            mergeSorted(res,arr,start,mid,end);
        }
    }
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        TreeSet<Integer> t = new TreeSet<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0;i<n;i++){
            t.add(arr1[i]);
            t.add(arr2[i]);
        }
        
        for(int i=0;i<n;i++){
            if(hm.get(arr2[i])==null)
            hm.put(arr2[i],i);
        }
        
        for(int i=0;i<n;i++){
           if(hm.get(arr1[i])==null)
            hm.put(arr1[i],n+i); 
        }
        
        //System.out.println(t.size());
        int size = Math.min(t.size(),n);
        int[] res = new int[size];
        for(int i=size-1;i>=0;i--){
            res[i]=t.last();
            //System.out.println(t.size());
            t.remove(res[i]);
        }
        
        //System.out.println(Arrays.toString(res));
        sortArray(res,hm,0,res.length-1);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<size;i++)
        arr.add(res[i]);
        
        return arr;
        
    }
}