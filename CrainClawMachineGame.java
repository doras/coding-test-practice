import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class CrainClawMachineGame {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int[] topOfBoard = new int[board.length];
        int answer = 0;

        Arrays.fill(topOfBoard, board.length);
        
        int i, j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (topOfBoard[j] == board.length && board[i][j] != 0) {
                    topOfBoard[j] = i;
                }
            }
        }

        for (int move : moves) {
            if (topOfBoard[move-1] >= board.length) {
                continue;
            }

            int pickedDoll = board[topOfBoard[move-1]][move-1];
            topOfBoard[move-1]++;

            try {
                if (bucket.peek() == pickedDoll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(pickedDoll);
                }
            } catch (EmptyStackException e) {
                bucket.push(pickedDoll);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CrainClawMachineGame obj = new CrainClawMachineGame();
        int[][] board = new int[][]{{0, 0, 0, 0, 0}, 
                                    {0, 0, 1, 0, 3}, 
                                    {0, 2, 5, 0, 1}, 
                                    {4, 2, 4, 4, 2}, 
                                    {3, 5, 1, 3, 1}};
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(obj.solution(board, moves));
    }
}