class Solution {
    
    public String reverse(String s){
        String res = "";
        for(int i=s.length()-1;i>=0;i--)
            res+=s.charAt(i);
        return res;
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++)
        arr[i] = reverse(arr[i]);
        
        String res="";
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
            if(i!=arr.length-1)
                res+=" ";
        }
            
        
        return res;
    }
}