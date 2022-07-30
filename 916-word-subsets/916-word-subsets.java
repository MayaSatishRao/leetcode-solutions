class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] alp = new int[26];
        for(int i=0;i<words2.length;i++){
              int[] temp = new int[26];
            for(int j=0;j<words2[i].length();j++){
                temp[words2[i].charAt(j)-'a']++;
            }
            
            for(int j=0;j<26;j++)
                alp[j]=Math.max(alp[j],temp[j]);
        }
        
        List<String> res = new ArrayList<String>();
        for(int i=0;i<words1.length;i++){
            int[] temp = new int[26];
            for(int j=0;j<words1[i].length();j++){
                temp[words1[i].charAt(j)-'a']++;
            }
            
            int j=0;
            for(;j<26;j++){
                if(alp[j]==0)
                    continue;
                if(alp[j]>temp[j])
                    break;
            }
            if(j==26)
                res.add(words1[i]);
              
        }
        
        return res;
    }
}