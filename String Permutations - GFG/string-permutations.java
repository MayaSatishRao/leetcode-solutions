//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void permute(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void getStrings(char[] str, int i, ArrayList<String> res){
        if(i==str.length){
            res.add(new String(str));
            return ;
        }
        
        for(int j=i;j<str.length;j++){
            permute(str,i,j);
            getStrings(str,i+1,res);
            permute(str,i,j);
        }
    }
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> res = new ArrayList<String>();
        char[] str = S.toCharArray();
        //Arrays.sort(str);
        getStrings(str,0,res);
        Collections.sort(res);
        return res;
    }
	   
}
