class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        
        
        while(true){
            String prev = dominoes;
            ArrayList<Integer> indices = new ArrayList<Integer>();
            for(int i=0;i<dominoes.length();i++){
                char curr = arr[i];
                char left = (i>0)?arr[i-1]:'.';
                char right = (i<arr.length-1)?arr[i+1]:'.';
                
                if((left!='.'|| right!='.') && curr=='.'){
                    indices.add(i);   
                }
                    
            }
            
            if(indices.size()==0)
                return new String(arr);
            
            for(int i=0;i<indices.size();i++){
                int j = indices.get(i);
                char left = (j>0)?dominoes.charAt(j-1):'.';
                char right = (j<arr.length-1)?dominoes.charAt(j+1):'.';
                if(left=='R' && right=='L')
                    arr[j]='.';
                else if(left=='R')
                    arr[j]='R';
                else if(right=='L')
                    arr[j]='L';
            }
            //System.out.println(indices);
            indices.clear();
            dominoes = new String(arr);
            
            if(prev.equals(dominoes))
                return dominoes;
        }
    }
}