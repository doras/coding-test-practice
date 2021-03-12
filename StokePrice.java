import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StokePrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<ArrayList<Integer>> stack = new Stack<>();

        int nowIndex;
        for (nowIndex = 0; nowIndex < prices.length; nowIndex++) {
            int size = stack.size();
            if (prices[nowIndex] > size) {
                for (int i = 0; i < prices[nowIndex] - size - 1; i++) {
                    stack.push(null);
                }
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nowIndex);
                stack.push(list);
            } else { // prices[nowIndex] <= size
                for (int i = 0; i < size - prices[nowIndex]; i++) {
                    ArrayList<Integer> list = stack.pop();
                    if (list == null) {
                        continue;
                    }
                    for (int indexFallen : list) {
                        answer[indexFallen] = nowIndex - indexFallen;
                    }
                }
                if (stack.peek() == null) {
                    stack.pop();
                    stack.push(new ArrayList<Integer>());
                }
                stack.peek().add(nowIndex);
            }
        }

        int size = stack.size();
        nowIndex--;
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = stack.pop();
            if (list == null) {
                continue;
            }
            for (int indexFallen : list) {
                answer[indexFallen] = nowIndex - indexFallen;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StokePrice obj = new StokePrice();
        int[] prices = {1, 5, 3, 2, 3, 10, 11, 13, 3};
        System.out.println(Arrays.toString(obj.solution(prices)));
    }
}
