package p0401;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<String>();

        for (int i = 0; i <= 11; i++) {
            int h = getBit(i);

            if (h > turnedOn) {
                continue;
            }

            for (int j = 0; j <= 59; j++) {
                int m = getBit(j);
                if (h + m == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(":");
                    if (j < 10) {
                        sb.append("0").append(j);
                    } else {
                        sb.append(j);
                    }
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }

    private int getBit(int v) {
        int count = 0;
        while (v != 0) {
            count += (v & 1);
            v = v >> 1;
        }
        return count;
    }

}
