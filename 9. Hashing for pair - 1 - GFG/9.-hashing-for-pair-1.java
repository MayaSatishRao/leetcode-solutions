// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String[] args) {

        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            // taking size of array
            int N = sc.nextInt();
            int arr[] = new int[N]; // array declaration

            for (int i = 0; i < N; i++) arr[i] = sc.nextInt(); // Input the
                                                               // array

            int sum = 0;

            // taking sum
            sum = sc.nextInt();

            // Creating an object of class Geeks
            Geeks obj = new Geeks();

            // Calling sumExists method of class Geeks
            // and printing the result
            System.out.println(obj.sumExists(arr, N, sum));
        }
    }
}

// Position this line where user code will be pasted.
// } Driver Code Ends


// User function Template for Java

class Geeks {
    // Complete this function
    // Function to check if there is a pair with the given sum in the array.
    public static int sumExists(int arr[], int N, int sum) {
        // Your code here, Geeks
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0;i<N;i++)
        hm.add(arr[i]);
        
        for(int i=0;i<N;i++){
            if(hm.contains(sum-arr[i]) && 2*arr[i]!=sum)
            return 1;
        }
        return 0;
    }
}