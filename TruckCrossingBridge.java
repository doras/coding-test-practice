import java.util.ArrayList;

public class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int crossingIndex = 0, waitingIndex = 0, nowWeight = 0;

        ArrayList<Integer> bridge = new ArrayList<>();

        while (true) {
            answer++;
            if (!bridge.isEmpty() && bridge.get(0) >= bridge_length) {
                bridge.remove(0);
                nowWeight -= truck_weights[crossingIndex];
                crossingIndex++;
            }

            if (crossingIndex >= truck_weights.length) {
                break;
            }

            if (waitingIndex < truck_weights.length && nowWeight + truck_weights[waitingIndex] <= weight) {
                nowWeight += truck_weights[waitingIndex];
                bridge.add(0);
                waitingIndex++;
            }

            for (int i = 0; i < bridge.size(); i++) {
                bridge.set(i, bridge.get(i) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TruckCrossingBridge obj = new TruckCrossingBridge();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(obj.solution(bridge_length, weight, truck_weights));
    }
}
