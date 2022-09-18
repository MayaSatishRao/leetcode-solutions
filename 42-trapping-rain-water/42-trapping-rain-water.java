class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.isEmpty() || s.peek()<=height[i]){
                left[i]=0;
                s.push(height[i]);
            }else
                left[i]=s.peek();
        }
        
        s.clear();
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty() || s.peek()<=height[i])
                s.push(height[i]);
            else
                right[i]=s.peek();
        }
        
        int res=0;
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++)
            if(Math.min(left[i],right[i])>0)
            res+=Math.min(left[i],right[i])-height[i];
        
        return res;
    }
}