import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    static class Development {
        int progress;
        int speed;

        public int getProgress() {
            return progress;
        }

        public int getSpeed() {
            return speed;
        }

        public void work() {
            progress += speed;
        }

        public Development (int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {

        List<Development> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            list.add(new Development(progresses[i], speeds[i]));
        }

        while (!list.isEmpty()) {
            for (Development dev : list) {
                dev.work();
            }

            int count = 0;
            while (!list.isEmpty() && list.get(0).getProgress() >= 100) {
                count++;
                list.remove(0);
            }

            if (count != 0) {
                answerList.add(count);
            }
        }

        int[] answer = new int[answerList.size()];
        int index = 0;
        for (Integer num : answerList) {
            answer[index++] = num;
        }

        return answer;
    }

    public static void main(String[] args) {
        FunctionDevelopment obj = new FunctionDevelopment();

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(obj.solution(progresses, speeds)));
    }
}
