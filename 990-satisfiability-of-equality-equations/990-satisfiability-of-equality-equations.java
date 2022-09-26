class Solution {
    public boolean equationsPossible(String[] equations) {
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i=0;i<equations.length;i++){
           String eq = equations[i];
            if(eq.charAt(1)=='='){
                String var1 = eq.substring(0,1), var2 = eq.substring(3,4);
                int ind1=-1,ind2=-1;
                for(int j=0;j<arr.size();j++){
                    if(arr.get(j).indexOf(var1)>=0)
                        ind1=j;
                    if(arr.get(j).indexOf(var2)>=0)
                        ind2=j;
                }
                
                if(ind1<0 && ind2<0){
                    arr.add((var1+var2));
                }else if(ind1<0){
                    arr.set(ind2,arr.get(ind2)+var1);
                }else if(ind2<0){
                    arr.set(ind1,arr.get(ind1)+var2);
                }else{
                    if(ind1!=ind2){
                    arr.set(ind1,arr.get(ind1)+arr.get(ind2));
                    arr.remove(ind2);
                    }
                }
            }
            //System.out.println(arr);
        }
        
        for(int i=0;i<equations.length;i++){
            String eq = equations[i];
            if(eq.charAt(1)=='!'){
                String var1 = eq.substring(0,1), var2 = eq.substring(3,4);
                int ind1=-1,ind2=-1;
                if(var1.equals(var2))
                    return false;
                for(int j=0;j<arr.size();j++){
                    if(arr.get(j).indexOf(var1)>=0)
                        ind1=j;
                    if(arr.get(j).indexOf(var2)>=0)
                        ind2=j;
                }
                
                if(ind1==-1 || ind2==-1)
                    continue;
                if(ind1==ind2)
                    return false;
            }
        }
        
        
        return true;
    }
}