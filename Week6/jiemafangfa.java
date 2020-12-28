package suanfa;

public class jiemafangfa {
	public int numDecodings(String s) {
        if(s.length() ==0){
            return 0;
        }     
        if(s.charAt(0) == '0'){
            return 0;
        }
        Integer dp[] = new Integer[s.length()+1];
        int pre = 1;
        int curr = 1;
        for(int i = 1; i < s.length(); i++){
            int tmp = curr;
            if(s.charAt(i) == '0'){
                if((s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
                    curr = pre; 
                }else{
                    return 0;
                }
            }
            else if(s.charAt(i-1) == '1'){
                    curr = curr + pre;   
                     }
            else if(s.charAt(i-1) == '2' &&  '0'< s.charAt(i) && s.charAt(i)  <= '6'){
                    curr = curr + pre;             } 
            pre = tmp;
        }
        return curr;
    }

}
