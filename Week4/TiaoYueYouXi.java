package suanfa;

public class TiaoYueYouXi {
	    public boolean canJump(int[] nums) {
	        int maxDis  = 0;
	        for(int i = 0 ; i < nums.length; i++){
	            if(i > maxDis){
	                return false;
	            }
	            maxDis = Math.max(i+nums[i], maxDis);
	        }
	        return true;     
	    }
}
