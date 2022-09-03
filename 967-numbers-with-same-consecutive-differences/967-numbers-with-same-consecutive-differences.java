class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<String> q = new LinkedList<String>();
        for(int i=0;i<10;i++){
            q.add(Integer.toString(i));
        }
        
        int d=1;
        while(d<n){
            
            int a = q.size();
            for(int i=0;i<a;i++){
                String p = q.poll();
                int num = p.charAt(0)-48;

                if(num-k>0 && num-k<10){
                    String num1 = "";
                    num1+=(char)(num-k+48);
                    num1+=p;
                    q.add(num1);
                }
                if(num-k==0 && d!=n-1){
                    String num1="0";
                    num1+=p;
                    q.add(num1);
                }
                
                if(k!=0 && k+num>0 && k+num<10){
                    String num1 = "";
                    num1+=(char)(k+num+48);
                    num1+=p;
                    q.add(num1);
                }
            }
            d++;
        }
        
        int[] res = new int[q.size()];
        int index=0;
        while(!q.isEmpty()){
            String p = q.poll();
            int num = Integer.valueOf(p);
            res[index]=num;
            index++;
        }
        
        return res;
    }
}