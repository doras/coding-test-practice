import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 1;

        int index = 0;

        List<Integer> priorityCheck = Arrays.stream(priorities).boxed().collect(Collectors.toList());

        Collections.sort(priorityCheck, Collections.reverseOrder());

        while (true) {
            if (priorities[index] < priorityCheck.get(0)) {
                index = (index + 1) % priorities.length;
                continue;
            }

            if (location == index) {
                break;
            }

            priorities[index] = 0;
            priorityCheck.remove(0);
            answer++;
            index = (index + 1) % priorities.length;
        }

        return answer;
    }


    public static void main(String[] args) {
        Printer obj = new Printer();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(obj.solution(priorities, location));
    }
}
