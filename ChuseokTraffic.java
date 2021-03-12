import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ChuseokTraffic {

    static class MyPeriod {
        LocalDateTime startTime;
        LocalDateTime endTime;

        public MyPeriod (LocalDateTime startTime, LocalDateTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }
    }

    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<MyPeriod> list = new ArrayList<>();

        for (String str : lines) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime endTime = LocalDateTime.parse(str.substring(0, 23), formatter);
            long durationLong = Integer.parseInt(str.substring(24, 25)) * 1000;
            if (str.charAt(25) == '.') {
                int ms = Integer.parseInt(str.substring(26, str.indexOf("s")));
                durationLong += ms;
            }
            durationLong = (durationLong - 1) * 1000000;
            LocalDateTime startTime = endTime.minusNanos(durationLong);

            list.add(new MyPeriod(startTime, endTime));
        }

        Collections.sort(list, (p1, p2) -> p1.getStartTime().compareTo(p2.getStartTime()));

        
        for (int i = 0; i < lines.length; i++) {
            int count = 1;
            LocalDateTime endTime = list.get(i).getStartTime();
            LocalDateTime startTime = endTime.minusNanos(999000000);
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
        // LocalDateTime time = LocalDateTime.parse("20:59:57.421");
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
