class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int periods = (minutesToTest/minutesToDie)+1;
        //System.out.println(periods);
        return (int)Math.ceil(Math.log(buckets)/Math.log(periods));
    }
}