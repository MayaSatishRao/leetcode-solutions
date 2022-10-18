class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String a = countAndSay(n-1);
        //System.out.println(a+" "+(n-1));
        String res="";
        int prev=a.charAt(0)-48,freq=1;
        for(int i=1;i<a.length();i++){
            if((a.charAt(i)-48)==prev)
                freq++;
            else{
                res+=Integer.toString(freq);
                res+=Integer.toString(prev);
                prev=a.charAt(i)-48;
                freq=1;
            }
        }
        res+=Integer.toString(freq);
        res+=Integer.toString(prev);
        return res;
    }
}