// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java
class Pair implements Comparable<Pair>{
    int data, freq;
    public Pair(int c, int d){
        data=c;
        freq=d;
    }
    
    public int compareTo(Pair p){
        if(p.freq==freq)
        return data-p.data;
        
        return p.freq-freq;
    }
}

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
        for(int i=0;i<n;i++){
            if(hm.get(arr[i])==null)
            hm.put(arr[i],1);
            else{
                int a = hm.get(arr[i]);
                hm.remove(arr[i]);
                hm.put(arr[i],a+1);
            }
        }
        
        Pair[] temp = new Pair[hm.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> ent: hm.entrySet()){
            temp[i]=new Pair(ent.getKey(),ent.getValue());
            i++;
        }
        
        Arrays.sort(temp);
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(i=0;i<temp.length;i++){
            int f = temp[i].freq;
            for(int j=0;j<f;j++)
            res.add(temp[i].data);
        }
        
        return res;
    }
}