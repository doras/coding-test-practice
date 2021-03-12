import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PickTwoAdd {
    public int[] solution(int[] numbers) {
        int[] answer;

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            answer[idx++] = num;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        PickTwoAdd obj = new PickTwoAdd();
        int[] numbers= {2,1,3,4,1};

        System.out.println(Arrays.toString(obj.solution(numbers)));
    }
}
