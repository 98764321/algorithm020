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

	        // ˫��BFS������
	        Queue<String> que1 = new LinkedList<>();
	        Queue<String> que2 = new LinkedList<>();

	        // ˫���¼����֮��ĵ㡣
	        Set<String> visited1 = new HashSet<>();
	        Set<String> visited2 = new HashSet<>();

	        que1.offer(beginWord);
	        que2.offer(endWord);

	        visited1.add(beginWord);
	        visited2.add(endWord);

	        int count = 0;
	        Set<String> allWordSet = new HashSet<>(wordList);

	        while(!que1.isEmpty() && !que2.isEmpty()){
	            // 1 visited1ָ����С��ÿ�ο�ʼ���ʵĽڵ㣬
	            // 2 que1 ָ��ÿ��Ҫ���ʵĿ�ʼ�ڵ����С�
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
	                        String newString = new String(words);                        // ����Ѿ����ʹ�������
	                        if(visited1.contains(newString)) {
	                            continue;  
	                        }
	                    // ���˱�����������������������count
	                        if(visited2.contains(newString)){
	                            return count+1;
	                        }
	                     // vistied1��û�з��ʵ��� visted2Ҳû�з��ʵ���
	                    // ����������б��д��ڣ�������ӵ����У������Ϊ�ѷ���  
	                // �����кܶ�ڵ㶼����ڵ㡣           
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

