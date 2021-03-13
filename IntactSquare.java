import java.math.BigInteger;

public class IntactSquare {
    public long solution(int w, int h) {
        long answer = 1;

        BigInteger wBig = BigInteger.valueOf(w);
        BigInteger hBig = BigInteger.valueOf(h);

        int gcdValue = wBig.gcd(hBig).intValue();

        int smallW = w / gcdValue;
        int smallH = h / gcdValue;

        answer = (smallH + smallW - 1) * gcdValue;
        answer = (long)w * (long)h - answer;    



        return answer;
    }

    public static void main(String[] args) {
        IntactSquare obj = new IntactSquare();

        int w = 100000000, h = 100000000;

        System.out.println(obj.solution(w, h));
    }
}
