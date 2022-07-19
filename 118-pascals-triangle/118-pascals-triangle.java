class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
                    
        List<Integer> ans=new ArrayList<Integer>();
        ans.add(1);
        answer.add(ans);
        
        if(n==1)
            return answer;
        
        List<Integer> ans1=new ArrayList<Integer>();
        ans1.add(1);
        ans1.add(1);
        answer.add(ans1);

        if(n==2)
            return answer;
        
        
        for(int i=3;i<=n;i++){
            List<Integer> ans2=new ArrayList<Integer>();
            List<Integer> prev=new ArrayList<Integer>();
            prev=answer.get(i-2);
            
            int k=0;
            
            ans2.add(1);
            for(int j=1;j<i-1 && k<i-1 ;j++){
               int sum=prev.get(k)+prev.get(k+1);
                ans2.add(sum);
                k++;
            }
            ans2.add(1);
            answer.add(ans2);
            
        }
        
        return answer;
    }
}