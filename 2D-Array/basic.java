import java.util.*;

public class basic {
    public static void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }

    public static void spiralPattern(int[][] matrix){

            
        int sr=0;
        int sc=0;
        int er=matrix.length-1;
        int ec=matrix[0].length-1;
         while(sr<=er && sc<=ec){
            int j=sc;
            int k=sr;
            //for upper border
            while(j<=ec){
                System.out.print(matrix[sr][j++]+" ");
            }
            
            //for right border
            k++;
            while(k<=er){
                System.out.print(matrix[k++][ec]+" ");
                
            }
            //System.out.println(k);
            //for down border
            j=ec-1;
            
            while(j >=sc){
                if(sr==er){
                    break;
                }
                System.out.print(matrix[er][j--]+" ");
            }

            //for left border
            k=er-1;
            while(k>=sr+1){
                if(sc==ec){
                    break;
                }
                System.out.print(matrix[k--][sc]+" ");
            }
            sr++;sc++;er--;ec--;
        }
    }

    public static boolean stairCaseSearch(int[][] matrix,int key){
        int row=0;
        int col=matrix[0].length-1;
        while(row<=matrix.length -1 && col>=0){
            if(matrix[row][col]==key){
                System.out.println("found key at"+row+","+col);
                return true;
            }else if(matrix[row][col]<key){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    public static void transposeMatrix(int matrix[][],int newMatrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i]=matrix[i][j];
            }
        }
    }

        public static void main(String[] args) {
        // int matrix[][]=new int[4][4];
        // int n=matrix.length;
        // int m =matrix[0].length;
        // Scanner sc=new Scanner(System.in);
        // for(int i=0;i<n;i++){
        //     for (int j = 0; j < m; j++) {
        //         matrix[i][j]=sc.nextInt();
        //     }
        // }

        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //spiralPattern(matrix);
        //System.out.println(stairCaseSearch(matrix,8 ));
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] newMatrix=new int[m][n];
        transposeMatrix(matrix, newMatrix);
        print(newMatrix);
       
    


    }
}