class Solution {
    public int trap(int[] height) {
        int n = height.length;
      /*  int[] left = new int[n];
        int[] right = new int[n];
        
        
        int currMax=0;
        for(int i=0;i<n;i++){
            if(currMax<=height[i]){
                left[i]=0;
                currMax=height[i];
            }else
                left[i]=currMax;
        }
        
        currMax=0;
        for(int i=n-1;i>=0;i--){
            if(currMax<=height[i])
                currMax=height[i];
            else
                right[i]=currMax;
        }
        
        int res=0;
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++)
            if(Math.min(left[i],right[i])>0)
            res+=Math.min(left[i],right[i])-height[i];
        
        return res;*/
        
        int leftMax=height[0],rightMax=height[n-1],left=0,right=n-1;
        int res=0;
        while(left<=right){
            
            if(leftMax<=rightMax){
                if(height[left]>leftMax)   
                    leftMax=height[left];
                else{
                   res+=leftMax-height[left];
                    left++;
                }
                    
            }else{
                if(height[right]>rightMax)
                    rightMax=height[right];
                else{
                    res+=rightMax-height[right];
                    right--;
                }
                    
            }
        }
        
        return res;
    }
}