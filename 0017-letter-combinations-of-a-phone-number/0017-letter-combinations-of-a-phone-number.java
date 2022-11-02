class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> arr = new ArrayList<String>();
        if(digits.length()==0)
            return arr;
        
        Queue<String> q = new LinkedList<String>();
        q.add("");
        
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");

        for(int i=0;i<digits.length();i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            String a = hm.get(digit);
            
            int b=q.size();
            for(int j=0;j<b;j++){
                String per = q.poll();
                for(int k=0;k<a.length();k++)
                    q.add(per+a.charAt(k));
            }
        }
        
        while(!q.isEmpty())
            arr.add(q.poll());
        return arr;
    }
}