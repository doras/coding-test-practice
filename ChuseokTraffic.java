import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class ChuseokTraffic {

    static class MyPeriod {
        LocalTime startTime;
        LocalTime endTime;

        public MyPeriod (LocalTime startTime, LocalTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public LocalTime getStartTime() {
            return startTime;
        }
    }

    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<MyPeriod> list = new ArrayList<>();

        for (String str : lines) {
            LocalTime endTime = LocalTime.parse(str.substring(11, 23));
            double durationDouble = Double.parseDouble(str.substring(24, str.indexOf("s", 24)));
            long durationLong = (Math.round(durationDouble * 1000) - 1) * 1000000;
            LocalTime startTime = endTime.minusNanos(durationLong);

            list.add(new MyPeriod(startTime, endTime));
        }

        Collections.sort(list, (p1, p2) -> p1.getStartTime().compareTo(p2.getStartTime()));

        
        for (int i = 0; i < lines.length; i++) {
            int count = 1;
            LocalTime endTime = list.get(i).getStartTime();
            LocalTime startTime = endTime.minusNanos(999000000);
            for (int j = i - 1; j >= 0; j--) {
                if (startTime.compareTo(list.get(j).getEndTime()) <= 0) {
                    count++;
                }
            }

            for (int j = i + 1; j < lines.length; j++) {
                if (endTime.compareTo(list.get(j).getStartTime()) != 0) {
                    break;
                }

                count++;
            }

            if (answer < count) {
                answer = count;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // LocalTime time = LocalTime.parse("20:59:57.421");
        // System.out.println(time);
        
        ChuseokTraffic obj = new ChuseokTraffic();
        String[] lines = {"2016-09-15 20:59:57.421 0.351s", 
                          "2016-09-15 20:59:58.233 1.181s", 
                          "2016-09-15 21:00:00.464 1.466s", 
                          "2016-09-15 20:59:58.299 0.8s", 
                          "2016-09-15 21:00:00.741 1.581s", 
                          "2016-09-15 20:59:58.688 1.041s", 
                          "2016-09-15 20:59:59.591 1.412s", 
                          "2016-09-15 21:00:00.748 2.31s", 
                          "2016-09-15 21:00:00.966 0.381s", 
                          "2016-09-15 21:00:02.066 2.62s"};
        System.out.println( obj.solution(lines) ) ;
    }
}
