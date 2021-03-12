import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StokePrice {

    static class MyPair {
        private int first;
        private int second;

        public MyPair(int a, int b) {
            first = a;
            second = b;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }


    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<MyPair> stack = new Stack<>();
        stack.push(new MyPair(0, 0));

        int nowIndex;
        for (nowIndex = 0; nowIndex < prices.length; nowIndex++) {
            if (prices[nowIndex] < stack.peek().getFirst()) {
                MyPair poppedPair = stack.pop();
                while (poppedPair.getFirst() > prices[nowIndex]) {
                    answer[poppedPair.getSecond()] = nowIndex - poppedPair.getSecond();
                    poppedPair = stack.pop();
                }
                stack.push(poppedPair);
            }
            stack.push(new MyPair(prices[nowIndex], nowIndex));
        }

        nowIndex--;
        MyPair poppedPair = stack.pop();
        while (poppedPair.getFirst() > 0) {
            answer[poppedPair.getSecond()] = nowIndex - poppedPair.getSecond();
            poppedPair = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        StokePrice obj = new StokePrice();
        int[] prices = {1, 5, 3, 2, 3, 10, 11, 13, 3};
        System.out.println(Arrays.toString(obj.solution(prices)));
    }
}
