//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void permute(char[] arr, int index, TreeSet<String> ts){
        if(index==arr.length-1){
            String p = new String(arr);
            ts.add(p);
            return ;
        }
        
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            permute(arr,index+1,ts);
            swap(arr,i,index);
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        TreeSet<String> ts = new TreeSet<>();
        char[] arr = S.toCharArray();
        permute(arr,0,ts);
        
        return new ArrayList<String>(ts);
    }
}