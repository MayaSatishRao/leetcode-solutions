class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0,j=0;
         int ind1=0,ind2=0;
        
        while(i<word1.length && j<word2.length){
            int len1 = word1[i].length(), len2 = word2[j].length();
            String a = word1[i], b=word2[j];
            
            while(ind1<len1 && ind2<len2){
                if(a.charAt(ind1) != b.charAt(ind2))
                    return false;
                ind1++;
                ind2++;
            }   
            
            if(ind1==len1){
                i++;
                ind1=0;
            }
            if(ind2==len2){
                j++;
                ind2=0;
            }
        }
        
        return (i==word1.length && j==word2.length);
    }
}