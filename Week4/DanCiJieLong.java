package suanfa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DanCiJieLong {  
	       public int ladderLength(String beginWord, String endWord, List<String> wordList)    
	    {    
	        int end = wordList.indexOf(endWord);
	        if(end == -1){
	            return 0;
	        }
	        
	        wordList.add(beginWord);

	        // 双向BFS遍历。
	        Queue<String> que1 = new LinkedList<>();
	        Queue<String> que2 = new LinkedList<>();

	        // 双向记录遍历之后的点。
	        Set<String> visited1 = new HashSet<>();
	        Set<String> visited2 = new HashSet<>();

	        que1.offer(beginWord);
	        que2.offer(endWord);

	        visited1.add(beginWord);
	        visited2.add(endWord);

	        int count = 0;
	        Set<String> allWordSet = new HashSet<>(wordList);

	        while(!que1.isEmpty() && !que2.isEmpty()){
	            // 1 visited1指向最小的每次开始访问的节点，
	            // 2 que1 指向每次要访问的开始节点序列。
	            count++;
	            if(que1.size() > que2.size()){
	                Queue<String> tmp = que1;
	                que1 = que2;
	                que2 = tmp;
	                Set<String> t = visited1;
	                visited1 = visited2;
	                visited2 = t;
	            }

	            int size1 = que1.size();
	            while(size1-- > 0){
	                String s = que1.poll();    
	                char[] words = s.toCharArray();
	                for(int i = 0; i < s.length(); i++){
	                    char c0 = words[i];
	                    for(char k = 'a'; k <='z'; k++){
	                        words[i] = k;
	                        String newString = new String(words);                        // 如果已经访问过，跳过
	                        if(visited1.contains(newString)) {
	                            continue;  
	                        }
	                    // 两端遍历相遇，结束遍历，返回count
	                        if(visited2.contains(newString)){
	                            return count+1;
	                        }
	                     // vistied1中没有访问到， visted2也没有访问到。
	                    // 如果单词在列表中存在，将其添加到队列，并标记为已访问  
	                // 其中有很多节点都是虚节点。           
	                    if (allWordSet.contains(newString)) {
	                            que1.offer(newString);
	                            visited1.add(newString);
	                        }
	                    }
	                    words[i] = c0;                
	                }       
	            }
	        }
	            return 0;
	    }
	}

