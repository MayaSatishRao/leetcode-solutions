class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        
        if(haystack.length()==needle.length()){
            int i=0;
            while(i<haystack.length()){
                if(haystack.charAt(i)!=needle.charAt(i))
                    return -1;
                i++;
            }
            return 0;
        }
        int res=0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=1,k=i+1;
                while(j<needle.length()){
                    if(k<haystack.length() && haystack.charAt(k)==needle.charAt(j)){
                        k++;
                        j++;
                    }else
                        break;
                }
                
                if(j==needle.length())
                    return i;
                    
            }
        }
        return -1;
    }
}