class Solution {
  
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        
       HashSet<Integer> hs = new HashSet<>();
        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(!hs.contains(freq[i]))
                    hs.add(freq[i]);
                else{
                    int newFreq = freq[i]-1;
                    while(hs.contains(newFreq))
                        newFreq--;
                    if(newFreq==0)
                        count+=freq[i];
                    else{
                        count+=freq[i]-newFreq;
                        hs.add(newFreq);
                    }
                }
            }
        }
        
        
        
        
        return count;
    }
}