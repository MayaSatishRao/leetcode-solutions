class Solution {
    public int minSubarraySum(int[] arr, int size){
       int sum=0;
        for(int i=0;i<size;i++)
            sum+=arr[i];
        int res=sum;
        for(int i=size;i<arr.length;i++){
            sum-=arr[i-size];
            sum+=arr[i];
            res=Math.min(sum,res);
        }
        return res;
    }
    public int maxScore(int[] cardPoints, int k) {
        int minSum = minSubarraySum(cardPoints,cardPoints.length-k),sum=0;
        for(int i=0;i<cardPoints.length;i++)
            sum+=cardPoints[i];
        return sum-minSum;
    }
}