package suanfa;
import java.util.*;
//分治搜索与回溯
//  first表示填到了第几个数，i 表示当前要填的数的下标。
//  [0,first-1] 都是标记的填过的数， [first, n-1] 表示没有填的数，
//  所以填的时候是将first到n-1中的数与i进行交换，将所有first之后的元素都循环放入。
//  交换完进行回溯。
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
	    // ｎ．全排列的长度。
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
