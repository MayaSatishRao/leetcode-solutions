class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Double> res = new ArrayList<Double>();
        double[] arr = new double[nums.length-k+1];
        if(k==1){
          for(int i=0;i<nums.length;i++)
            arr[i]=(double)nums[i];
        
             return arr;
        }
        PriorityQueue<Integer> large = new PriorityQueue<Integer>();
        PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0;i<k;i++){
            if(small.size()==0)
                small.add(nums[i]);
            else if(small.size()>large.size()){
                if(nums[i]<small.peek()){
                    large.add(small.poll());
                    small.add(nums[i]);
                }else
                    large.add(nums[i]);
            }else{
                
                if(nums[i]>large.peek()){
                    small.add(large.poll());
                    large.add(nums[i]);
                }else
                    small.add(nums[i]);
            }
        }
        
        int j=0;
         if(small.size()!=large.size())
            arr[j]=(double)small.peek();
            else
            arr[j]=((double)small.peek()+(double)large.peek())/2;
        j++;
        
        for(int i=k;i<nums.length;i++){
            if(nums[j-1]<large.peek())
                small.remove(nums[j-1]);
            else
                large.remove(nums[j-1]);
            
            if(small.size()==0)
                small.add(nums[i]);
            else if(small.size()>large.size()){
                if(nums[i]<small.peek()){
                    large.add(small.poll());
                    small.add(nums[i]);
                }else
                    large.add(nums[i]);
            }else{
                
                if(nums[i]>large.peek()){
                    small.add(large.poll());
                    large.add(nums[i]);
                }else
                    small.add(nums[i]);
            }
            
            
            if(small.size()!=large.size())
            arr[j]=(double)small.peek();
            else
            arr[j]=((double)small.peek()+(double)large.peek())/2;
            
            //System.out.println(small+" "+large);
            j++;
        }
        
        
        
        return arr;

    }
}