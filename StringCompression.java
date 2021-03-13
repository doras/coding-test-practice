public class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        
        int maxUnit = s.length() / 2;
        
        for (int unit = 1; unit <= maxUnit; unit++) {
            String shortStr = "";
            int baseIdx = 0;
            int forwardIdx = unit;
            int count;

            while (forwardIdx + unit <= s.length()) {
                if (!s.substring(baseIdx, forwardIdx).equals(s.substring(forwardIdx, forwardIdx + unit))) {
                    shortStr += s.substring(baseIdx, forwardIdx);
                    baseIdx += unit;
                    forwardIdx = unit + baseIdx;
                    continue;
                }

                for (count = 2, forwardIdx += unit; forwardIdx + unit <= s.length(); forwardIdx += unit) {
                    if (s.substring(baseIdx, baseIdx + unit).equals(s.substring(forwardIdx, forwardIdx + unit))) {
                        count++;
                    } else {
                        break;
                    }
                }

                shortStr = shortStr + String.valueOf(count) + s.substring(baseIdx, baseIdx + unit);
                baseIdx = forwardIdx;
                forwardIdx += unit;
            }

            shortStr += s.substring(baseIdx);

            if (answer > shortStr.length()) {
                answer = shortStr.length();
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        String s = "a";
        System.out.println(obj.solution(s));
    }
}
