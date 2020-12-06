package suanfa;

import java.util.*;

public class Pailie2 {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(length == 0){
            return res; 
        }   

        List<Integer> per = new ArrayList<>();      
        boolean[] visited = new boolean[length];
        Arrays.sort(nums);
        huisupailie(nums,length,per,res,visited,0);
        return res;
 }

    public void huisupailie(int[] nums, int length, List<Integer> per, List<List<Integer>>  res,boolean[] visited, int no){
        if(no == length){
            res.add(new ArrayList<Integer>(per));
            return;
        }

        for(int i = 0; i < length ; i++){
            //  处理重复问题  序列是有序的情况下：如果当前位置元素i和前一个位置元素i-1重复，
            //  如果前一个元素刚在当前位置回溯，visited[i-1] = false， 那么当前子分支剪掉。
            //  除此之外的情况visited[i-1] = true.

            if(visited[i] || i > 0 && nums[i]== nums[i-1] && visited[i-1] == false )
                continue;
            per.add(nums[i]);
            visited[i] = true;
            huisupailie(nums, length, per, res, visited, no+1);
            // 回溯
            visited[i] = false;
            per.remove(no);
        }
    }
	
	

}
