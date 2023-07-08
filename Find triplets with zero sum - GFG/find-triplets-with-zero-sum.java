//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                int req = 0-sum;
                if(arr[i]==req && arr[j]==req){
                    if(hm.get(arr[i])>=3)
                    return true;
                }else if(req==arr[i] || req==arr[j]){
                    if(hm.get(req)>=2)
                     return true;
                }else if(hm.get(req)!=null)
                   return true;

            }
        }
        
        return false;
    }
}