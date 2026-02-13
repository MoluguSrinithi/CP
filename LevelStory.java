/*
In a game, a player starts at level n and wants to reach level 1.
The game engine applies these rules:

If the current level is even, the level is reduced to half.
If the current level is odd, the player may move one level up or down.

The goal is to reach level 1 in the minimum number of moves.


Example 1:
--------------
Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1

Example 2:
--------------
Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1

Constraints:
---------------
1 <= n <= 231 - 1


*/
import java.util.*;

class LevelStory {
    public static int levelStory (int num) {
        int moves = 0;
        while (num > 0) {
            if (num == 1) break;
            else if ((num & 1) == 0) num >>= 1;
            else {
                if (num == 3 || (num & 3) == 1) num--;
                else num++;
            }
            moves++;
        }
        return moves;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(levelStory(num));
    }
}