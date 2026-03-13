import java.util.*;
class RemoveOnes{
    public static boolean removeOnes(int[][]grid){
        int row = grid.length;
        int col = grid[0].length;

        for(int c = 0; c<col; c++){
            if(grid[0][c] == 1){
                for(int r = 0; r<row; r++){
                    grid[r][c]^=1;
                }
            }
        }

        for(int i = 0; i<row; i++){
            int sum = 0;
            for(int c = 0; c<col; c++){
                sum+=grid[i][c];
            }

            if(sum == 0 || sum == col){
                continue;
            }
            if(sum!=0 && sum!=col){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int grid[][] = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(removeOnes(grid));

    }
}