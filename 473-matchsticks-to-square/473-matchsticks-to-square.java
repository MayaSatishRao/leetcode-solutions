class Solution {
    
    public boolean dfs(int[] arr, int curr, int[] sticks, int len){
        if(curr==arr.length){
            int s = sticks[0];
            for(int i=1;i<4;i++)
                if(sticks[i]!=s)
                    return false;
            return true;
        }
        
        for(int i=0;i<4;i++){
            sticks[i]+=arr[curr];
            if(arr[curr]<=len && sticks[i]<=len && dfs(arr,curr+1,sticks,len))
                return true;
            sticks[i]-=arr[curr];
        }
        
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++)
            sum+=matchsticks[i];
        
        if(sum%4!=0)
            return false;
        Arrays.sort(matchsticks);
        int i=0,j=matchsticks.length-1;
        while(i<j){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j]=temp;
            i++;
            j--;
        }
        int[] sides = new int[4];
        return dfs(matchsticks,0,sides,sum/4);
    }
}