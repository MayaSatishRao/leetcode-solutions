class Solution {
    
    public String reverseK(String s, int start, int k){
        int end = (s.length()-1<(start+k-1))?s.length()-1:start+k-1;
        int i=start,j=end;
        char arr[] = s.toCharArray();
        while(i<j){
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            
            i++;
            j--;
        }
        
        return new String(arr);
    }
    public String reverseStr(String s, int k) {
        int i=0;
        while(i<s.length()){
            s = reverseK(s,i,k);
            i+=2*k;
        }
        return s;
    }
}