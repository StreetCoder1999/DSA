public class RatMaze {
    public static void printMaze(int[][] maze){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print("  "+maze[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println();
    }
    public static void ratInMaze(int maze[][], int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {
            maze[i][j]=0;

            printMaze(maze);
            return;
        }
        if (i < 0 || j < 0 || j > m-1 || i > n-1||maze[i][j]==-1||maze[i][j]==0) {
            return;
        }
        
            maze[i][j]=0;
            ratInMaze(maze, i - 1, j, n, m);
            ratInMaze(maze, i + 1, j, n, m);
            ratInMaze(maze, i, j - 1, n, m);
            ratInMaze(maze, i, j + 1, n, m);
            maze[i][j]=1;
        

    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, -1, -1, -1 },
                { 1, 1, -1, 1 },
                { -1, 1, 1, -1 },
                { 1, 1, 1, 1 }
        };
        ratInMaze(maze, 0, 0, 4, 4);
    }
}
