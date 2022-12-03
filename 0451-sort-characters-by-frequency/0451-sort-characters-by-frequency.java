class Element implements Comparable<Element>{
     char c;
     int fr;
    
     public Element(char d, int f){
         c=d;
         fr=f;
     }
    
     public int compareTo(Element a){
         return a.fr-this.fr;
     }
}




class Solution {
    
    public int contains(ArrayList<Element> arr, char c){
        if(arr.size()==0)
            return -1;
        
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).c==c)
                return i;
        }
        return -1;
    }
    public String frequencySort(String s) {
        ArrayList<Element> arr = new ArrayList<Element>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int a = contains(arr,ch);
            if(a>=0){
                arr.get(a).fr++;
            }else{
                Element b = new Element(ch,1);
                arr.add(b);
            }
        }
        
        Collections.sort(arr);
        
        String res="";
        for(int i=0;i<arr.size();i++){
            while(arr.get(i).fr>0){
                res+=arr.get(i).c;
                arr.get(i).fr--;
            }
        }
        
        return res;
    }
}