package p1904;

public class Solution {

    public int numberOfRounds(String startTime, String finishTime) {
        Time start = new Time(startTime);
        Time end = new Time(finishTime);

        int s = start.toMinutes();
        int e = end.toMinutes();

        if (s > e) {
            start.mod();
            int ms = start.toMinutes();
            return (24 * 60 - ms + e) / 15;
        } else {
            start.mod();
            int ms = start.toMinutes();
            return e > ms ? (e - ms) / 15 : 0;
        }
    }

    public class Time {
        public int h;
        public int m;

        public Time(String time) {
            int split = time.indexOf(":");
            h = Integer.valueOf(time.substring(0, split));
            m = Integer.valueOf(time.substring(split + 1));
        }

        private void mod() {
            if (m > 45) {
                this.h++;
                this.m = 0;
            } else if (m > 30) {
                this.m = 45;
            } else if (m > 15) {
                this.m = 30;
            } else if (m > 0) {
                this.m = 15;
            }
        }

        private int toMinutes() {
            return this.h * 60 + this.m;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        // System.out.println(s.numberOfRounds("12:01", "12:44"));
        // System.out.println(s.numberOfRounds("20:00", "06:00"));
        // System.out.println(s.numberOfRounds("00:00", "23:59"));
        System.out.println(s.numberOfRounds("00:47", "00:57"));
    }

}
