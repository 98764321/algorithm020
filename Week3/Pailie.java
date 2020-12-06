package suanfa;
import java.util.*;
//�������������
//  first��ʾ��˵ڼ�������i ��ʾ��ǰҪ��������±ꡣ
//  [0,first-1] ���Ǳ�ǵ���������� [first, n-1] ��ʾû���������
//  �������ʱ���ǽ�first��n-1�е�����i���н�����������first֮���Ԫ�ض�ѭ�����롣
//  ��������л��ݡ�
public class Pailie {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> output = new ArrayList<Integer>();
	        for (int num : nums) {
	            output.add(num);
	        }

	        int n = nums.length;
	        backtrack(n, output, res, 0);
	        return res;
	    }   
	    // �ȫ���еĳ��ȡ�
	    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
	        
	        if (first == n) {
	            res.add(new ArrayList<Integer>(output));
	        }
	        for (int i = first; i < n; i++) {
	            Collections.swap(output, first, i);
	            backtrack(n, output, res, first + 1);
	            Collections.swap(output, first, i);
	        }
	    }
}
