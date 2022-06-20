class Solution {
    public int minimumLengthEncoding(String[] words) {
        String res="";
        Arrays.sort(words,(a,b)->b.length()-a.length());
        for(int i=0;i<words.length;i++){
            int index = res.indexOf(words[i]+"#");
            if(index<0){
                res+=words[i];
                res+="#";
            }
        }
        
        return res.length();
    }
}