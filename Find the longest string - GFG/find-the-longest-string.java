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
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        HashSet<String> hs = new HashSet<>();
        String res="";
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            String prefix="";
            boolean found=true;
            
            for(int j=0;j<str.length();j++){
                prefix+=str.charAt(j);
                if(!hs.contains(prefix)){
                    found=false;
                    break;
                }
            }
            
            if(found){
                if(res.length()<str.length())
                  res=new String(str);
                else if(res.length()==str.length() && str.compareTo(res)<0)
                  res=new String(str);
            }
        }
        
        return res;
    }
}
        
