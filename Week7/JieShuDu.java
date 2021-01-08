package suanfa;

public class JieShuDu {
	
	    public void solveSudoku(char[][] board) {
	        if(board == null || board.length == 0){
	            return;
	        }
	        solve(board);
	    }

	    public boolean solve(char[][] board){
	        for(int i = 0 ; i < board.length; i++){
	            for(int j = 0 ; j < board[0].length; j++){
	                if(board[i][j] == '.'){
	                    for(char c = '1'; c <= '9'; c++){
	                         if(isValid(board, i, j, c)){
	                             board[i][j] = c;
	                             if(solve(board)){
	                                return true;
	                             }else{
	                                board[i][j] = '.';
	                             }
	                         }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	 
	   // �ж���ͬ���к�һ��9�������Ƿ���
	   // ��0��ʼ���������Կ����Ǳ���ǰ���ж���������
	    public boolean isValid(char[][] board, int row, int col, char c){
	        for(int i = 0; i < 9; i++){
	            // �鿴��һ���Ƿ������ֺ����ظ�
	            if(board[i][col] != '.' && board[i][col] == c) return false; 
	            // ��һ���Ƿ������ֺ����ظ�
	            if(board[row][i] !='.' && board[row][i] == c)  return false; 
	            if(board[3*(row/3)+i/3][3*(col/3)+i%3]!='.' && 
	            board[3*(row/3) + i /3][3* (col /3)+i%3] ==c)
	                return false;

	        }
	        return true;

	        }
 }


