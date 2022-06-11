// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==null)
            hm.put(arr[i],1);
            else{
                int a = hm.get(arr[i]);
                hm.remove(arr[i]);
                hm.put(arr[i],a+1);
            }
        }
        
        int max=Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry mapElement : hm.entrySet()){
            String key = (String)mapElement.getKey();
            int value = (int)mapElement.getValue();
            
            if(value>max){
                res=new String(key);
                max=value;
            }else if(value==max){
                if(res.compareTo(key)>0)
                res=new String(key);
            }
        }
            
        
        
        String[] r= new String[2];
        r[0]=res;
        r[1]=Integer.toString(max);
        
        return r;
    }
}

