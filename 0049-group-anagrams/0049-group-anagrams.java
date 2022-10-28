class Solution {
    
    public int[] countFrequencies(String s){
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++)
            arr[(int)s.charAt(i)-'a']++;
        
        return arr;
    }
    
    public boolean same(int[] arr1, int[] arr2){
        if(arr1.length!=arr2.length)
            return false;
        
        for(int i=0;i<arr1.length;i++)
            if(arr1[i]!=arr2[i])
                return false;
        
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        int n = strs.length;
        int[][] alp = new int[n][26];
        
        for(int i=0;i<n;i++){
            alp[i] = countFrequencies(strs[i]);
        }
        
        boolean[] arr = new boolean[n];
        Arrays.fill(arr,false);
        for(int i=0;i<n;i++){
            if(!arr[i]){
                List<String> ans = new ArrayList<String>();
                ans.add(strs[i]);
                for(int j=i+1;j<n;j++){
                    if(same(alp[i],alp[j])){
                        ans.add(strs[j]);
                        arr[j]=true;
                    }
                }
                res.add(ans);
            }
        }
        
        return res;
    }
}