//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
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
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int i=N1-1, j=N2-1, k=N3-1;
        int s1=0, s2=0, s3=0,res=0;
        while(i>=0 && j>=0 && k>=0){
            int s = Math.max(s1,Math.max(s2,s3));
            if(s1==s2 && s2==s3){
                s1+=S1[i];
                s2+=S2[j];
                s3+=S3[k];
                i--;
                j--;
                k--;
                continue;
            }
            
            if(s1<s){
                s1+=S1[i];
                i--;
            }
            if(s2<s){
                s2+=S2[j];
                j--;
            }
            if(s3<s){
                s3+=S3[k];
                k--;
            }
            
            if(s1==s2 && s2==s3)
              res=s1;
        }
        
        //System.out.println(s1+" "+s2+" "+s3);
        while(i>=0 && j>=0){
            int s = Math.max(s1,s2);
            if(s1==s2){
                s1+=S1[i];
                s2+=S2[j];
                i--;
                j--;
                continue;
            }
            if(s1<s){
                s1+=S1[i];
                i--;
            }
            if(s2<s){
                s2+=S2[j];
                j--;
            }
             if(s1==s2 && s2==s3)
              res=s1;
        }
        
        while(j>=0 && k>=0){
            int s = Math.max(s3,s2);
            if(s3==s2){
                s3+=S3[k];
                s2+=S2[j];
                k--;
                j--;
                continue;
            }
            if(s3<s){
                s3+=S3[k];
                k--;
            }
            if(s2<s){
                s2+=S2[j];
                j--;
            }
             if(s1==s2 && s2==s3)
              res=s1;
        }
        
        while(i>=0 && k>=0){
             int s = Math.max(s3,s1);
            if(s3==s1){
                s3+=S3[k];
                s1+=S1[i];
                k--;
                i--;
                continue;
            }
            if(s3<s){
                s3+=S3[k];
                k--;
            }
            if(s1<s){
                s1+=S1[i];
                i--;
            }
             if(s1==s2 && s2==s3)
              res=s1;
        }
        //System.out.println(s1+" "+s2+" "+s3);
        while(i>=0){
            s1+=S1[i];
            i--;
             if(s1==s2 && s2==s3)
              res=s1;
        }
        
        while(j>=0){
            s2+=S2[j];
            j--;
             if(s1==s2 && s2==s3)
              res=s1;
        }
        
        while(k>=0){
             s3+=S3[k];
            k--;
             if(s1==s2 && s2==s3)
              res=s1;
        }
        
        if(s1==s2 && s2==s3)
         res=s1;
         
        return res;
    }
}
        
