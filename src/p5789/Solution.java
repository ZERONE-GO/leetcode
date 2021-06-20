package p5789;

public class Solution {

    public int numberOfRounds(String startTime, String finishTime) {
        Time start = new Time(startTime);
        start.mod();
        Time end = new Time(finishTime);

        int s = start.toMinutes();
        int e = end.toMinutes();

        if (s > e) {
            return (24 * 60 - s + e) / 15;
        } else {
            return (e - s) / 15;
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
        System.out.println(s.numberOfRounds("08:31", "02:07"));
    }

}
