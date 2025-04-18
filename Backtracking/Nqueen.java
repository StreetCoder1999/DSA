public class Nqueen {



    public static void nQueens(char board[][],int row){
        //base 
        if(row==board.length){
            printBoard(board);
            return;
        }
        //column loop
        for (int i = 0; i < board.length; i++) {
            if(isSafe(row,i,board)){
                board[row][i]='Q';
                nQueens(board, row+1); //function call
                board[row][i]='x'; //backtracking step
            }
            
            
        }
    }


    public static boolean isSafe(int row,int col,char board[][]){
        int n=board.length;
        //for vertical
        int i=0;
        while(i<board.length){
            if(board[i][col]=='Q'){
                return false;
            }
            i++;
        }
        //for horizontal
        int j=0;
        while(j<board.length){
            if(board[row][j]=='Q'){
                return false;
            }
            j++;
        }

        //for diagonal
        //for upper left diagonal
        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }

          //for upper right diagonal
          i=row-1;
          j=col+1;
          while(i>=0 && j<=n-1){
              if(board[i][j]=='Q'){
                  return false;
              }
              i--;
              j++;
          }

            //for lower left diagonal
        i=row+1;
        j=col-1;
        while(i<=n-1 && j>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i++;
            j--;
        }

          //for lower left diagonal
          i=row+1;
          j=col+1;
          while(i<=n-1 && j<=n-1){
              if(board[i][j]=='Q'){
                  return false;
              }
              i++;
              j++;
          }


        return true;
    }



    public static void printBoard(char board[][]){
        System.out.println("------------ chess board-----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=6;
        char board[][]=new char[n][n];
        //initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='x';
            }
        }

        nQueens(board,0);
    }
}
