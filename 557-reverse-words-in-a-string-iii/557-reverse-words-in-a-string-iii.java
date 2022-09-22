class Solution {
    
    public String reverse(String s){
        String res = "";
        for(int i=s.length()-1;i>=0;i--)
            res+=s.charAt(i);
        return res;
    }
    public String reverseWords(String s) {
      /*  String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++)
        arr[i] = reverse(arr[i]);
        
        String res="";
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
            if(i!=arr.length-1)
                res+=" ";
        }*/
        
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();){
            int j=i+1;
            while(j<s.length() && s.charAt(j)!=' ')
                j++;
            int start = i,end=j-1;
            while(start<end){
                char ch = arr[start];
                arr[start]=arr[end];
                arr[end]=ch;
                start++;
                end--;
            }
            
            
            i=j+1;
        }
            
        
        return new String(arr);
    }
}