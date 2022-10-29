class Data{
    int time;
    int index;
    
    Data(int a, int b){
        time=a;
        index=b;
    }
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        
        Data[] arr = new Data[n];
        for(int i=0;i<n;i++)
            arr[i]= new Data(growTime[i],i);
        
        Arrays.sort(arr,(a,b)->{
            if(a.time==b.time)
                return plantTime[b.index]-plantTime[a.index];
            return b.time-a.time;
        });
        
        int result=0;
        for(int i=0, currTime=0;i<n;i++){
            int j = arr[i].index, t=arr[i].time;
            int time = currTime+t+plantTime[j];
            result = Math.max(result,time);
            currTime+=plantTime[j];
        }
        
        return result;
    }
}