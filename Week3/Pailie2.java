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
            //  �����ظ�����  ���������������£������ǰλ��Ԫ��i��ǰһ��λ��Ԫ��i-1�ظ���
            //  ���ǰһ��Ԫ�ظ��ڵ�ǰλ�û��ݣ�visited[i-1] = false�� ��ô��ǰ�ӷ�֧������
            //  ����֮������visited[i-1] = true.

            if(visited[i] || i > 0 && nums[i]== nums[i-1] && visited[i-1] == false )
                continue;
            per.add(nums[i]);
            visited[i] = true;
            huisupailie(nums, length, per, res, visited, no+1);
            // ����
            visited[i] = false;
            per.remove(no);
        }
    }
	
	

}
