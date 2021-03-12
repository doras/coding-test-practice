public class NumberOf124 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = new char[]{'4','1','2'};
        
        
        while (n > 0) {
            sb.append(charArr[n%3]);
            n = (n-1) / 3;
        }
        
        String answer = sb.reverse().toString();
        return answer;
    }

    public static void main(String[] args) {
        NumberOf124 obj = new NumberOf124();

        for (int i = 1; i < 100; i++) {
            System.out.println(i + ": " + obj.solution(i));
        }
    }
}
