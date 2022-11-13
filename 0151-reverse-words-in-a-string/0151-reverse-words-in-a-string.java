class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        String res=" ";
        
        for(int i=0;i<n;){
           int j=i;
            while(j<n && (Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j))))
                j++;
            if(j>i){
              String a = s.substring(i,j);
              StringBuilder r = new StringBuilder(a);
            
              res+=r.reverse().toString();
              res+=" "; 
                i=j+1;
            }else
                i++;
        }
        
        //System.out.println(res);
        String a = res.substring(1,res.length()-1);
        StringBuilder r = new StringBuilder(a);
        
        return r.reverse().toString();
    }
}