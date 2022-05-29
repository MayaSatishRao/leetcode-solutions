class Solution {
    
   public int[] getState(String[] arr){
       int n = arr.length;
       int[] res = new int[n];
       for(int i=0;i<arr.length;i++){
           int state=0;
           for(int j=0;j<arr[i].length();j++){
               int power  = arr[i].charAt(j)-'a';
               state|=1<<power;
           }
           res[i]=state;
       }
       return res;
   }
    
    public int maxProduct(String[] words) {
        int product=0,n=words.length;
        int[] res = getState(words);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((res[i]&res[j])==0)
                    product=Math.max(product,words[i].length()*words[j].length());
            }
        }
       
        return product;
    }
}