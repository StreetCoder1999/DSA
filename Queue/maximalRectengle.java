public class maximalRectengle {
    public static int maxRectangle(int[][] arr,int row,int col){
        int[][] prefixSum=new int[row][col];
        for(int j=0;j<col;j++){
            int sum=0;
            for(int i=0;i<row;i++){
                sum+=arr[i][j];
                if(arr[i][j]==0){
                    sum=0;
                }
                prefixSum[i][j]=sum;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(prefixSum[i][j]);
            }
            System.out.println();
        }
        return 1;
    }
    public static void main(String[] args) {
        int [][] arr={
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0},
        };
        System.out.println(maxRectangle(arr,4,5));
    }
}
