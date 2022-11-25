class Pair{
    int el, freq;
    Pair(int a, int b){
        el=a;
        freq=b;
    }
}

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long sum=0;
        
        int pr = (int)Math.pow(10,9)+7;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Pair> stk = new Stack<>();
        stk.add(new Pair(arr[0],1));
        left[0]=1;
        for(int i=1;i<n;i++){
            int f=1;
            while(!stk.isEmpty() && stk.peek().el>arr[i]){
                Pair q = stk.pop();
                f+=q.freq;
            }
            stk.push(new Pair(arr[i],f));
            left[i]=f;
        }
        
        stk=new Stack<>();
        stk.push(new Pair(arr[n-1],1));
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            int f=1;
            while(!stk.isEmpty() && stk.peek().el>=arr[i]){
                Pair q = stk.pop();
                    f+=q.freq;
            }
            stk.push(new Pair(arr[i],f));
            right[i]=f;
        }
        
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++){
            sum +=left[i]*right[i]*(long)arr[i]; 
            sum %= pr;
            //System.out.println(sum+" "+ans);
        }
        return (int)sum;
    }
}