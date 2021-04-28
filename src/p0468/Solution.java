package p0468;

public class Solution {

    public String validIPAddress(String IP) {
        boolean ipv4 = validIPv4(IP);
        if(ipv4) {
            return "IPv4";
        }
        boolean ipv6 = validIPv6(IP);
        if(ipv6) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validIPv6(String IP) {
        int count = 1;

        int left = 0, right = 0;
        while (right < IP.length()) {
            if (IP.charAt(right) == ':') {
                if (validV6(IP, left, right)) {
                    right++;
                    count++;
                    left = right;
                } else {
                    return false;
                }
            } else {
                right++;
            }
        }
        if (validV6(IP, left, right)) {
            right++;
        } else {
            return false;
        }

        return count == 8;
    }

    private boolean validV6(String IP, int left, int right) {
        // ::
        if (right - left <= 0) {
            return false;
        }
        // 1234e
        if (right - left > 4) {
            return false;
        }

        for (int i = left; i < right; i++) {
            if (!isSixteen(IP.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isSixteen(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private boolean validIPv4(String IP) {
        int count = 0;

        int left = 0, right = 0;
        while (right < IP.length()) {
            if (IP.charAt(right) == '.') {
                if (validV4(IP, left, right - 1)) {
                    count++;
                    right++;
                    left = right;
                } else {
                    return false;
                }
            } else {
                right ++;
            }
        }
        
        if (validV4(IP, left, right - 1)) {
            count++;
        } else {
            return false;
        }

        return count == 4;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean validV4(String IP, int left, int right) {
        // ..10.10.1
        if (left > right) {
            return false;
        }
        // 01.01.01.1
        if (left < right && IP.charAt(left) == '0') {
            return false;
        }
        // 1111.1111.111.11
        if (right - left >= 3) {
            return false;
        }
        int phase = 0;
        for (int i = left; i <= right; i++) {
            if(isNum(IP.charAt(i))) {
                phase = phase * 10 + IP.charAt(i) - '0';
            } else {
                return false;
            }
        }
        return phase >= 0 && phase <= 255;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.validIPAddress("1.1.1."));
    }
}
