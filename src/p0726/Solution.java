package p0726;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public String countOfAtoms(String formula) {
        List<Autom> automList = new ArrayList<Autom>();
        Stack<Integer> phases = new Stack<Integer>();

        int l = 0;
        while (l < formula.length()) {
            if (formula.charAt(l) == '(') {
                phases.add(automList.size());
                l++;
            } else if (formula.charAt(l) == ')') {
                l++;

                int times = 0;
                while (l < formula.length() && isNum(formula.charAt(l))) {
                    times = times * 10 + formula.charAt(l) - '0';
                    l++;
                }
                times = times == 0 ? 1 : times;
                int left = phases.pop();
                for (int i = left; i < automList.size(); i++) {
                    Autom autom = automList.get(i);
                    autom.mutply(times);
                }
            } else {
                l = nextAutom(formula, l, automList);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (Autom autom : automList) {
            map.put(autom.autom, map.getOrDefault(autom.autom, 0) + autom.num);
        }

        List<String> keys = new ArrayList<String>();
        keys.addAll(map.keySet());
        keys.sort((a, b) -> {
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            if(map.get(key) > 1 ) {
                sb.append(map.get(key));
            }
        }

        return sb.toString();
    }

    private int nextAutom(String formula, int l, List<Autom> automList) {
        StringBuilder sb = new StringBuilder();
        int status = 0;

        while (l < formula.length() && status != 4) {
            char c = formula.charAt(l);
            if (status == 0) {
                if (isUper(c)) {
                    sb.append(c);
                    l++;
                    status = 1;
                } else {
                    status = 4;
                }
            } else if (status == 1) {
                if (isNum(c)) {
                    sb.append(c);
                    l++;
                    status = 3;
                } else if (isLower(c)) {
                    sb.append(c);
                    l++;
                    status = 2;
                } else {
                    Autom autom = new Autom(sb.toString());
                    automList.add(autom);
                    status = 4;
                }
            } else if (status == 2) {
                if (isLower(c)) {
                    sb.append(c);
                    status = 2;
                    l++;
                } else if (isNum(c)) {
                    sb.append(c);
                    status = 3;
                    l++;
                } else {
                    Autom autom = new Autom(sb.toString());
                    automList.add(autom);
                    status = 4;
                }
            } else if (status == 3) {
                if (isNum(c)) {
                    sb.append(c);
                    status = 3;
                    l++;
                } else {
                    Autom autom = new Autom(sb.toString());
                    automList.add(autom);
                    status = 4;
                }
            }
        }
        if(status != 4) {
            Autom autom = new Autom(sb.toString());
            automList.add(autom);
            status = 4;
        }
        return l;
    }

    private boolean isUper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    class Autom {
        public String autom;
        public int num;

        public Autom(String str) {
            int l = str.length() - 1;
            while (isNum(str.charAt(l))) {
                l--;
            }
            autom = str.substring(0, l + 1);
            num = l + 1 >= str.length() ? 1 : Integer.valueOf(str.substring(l + 1));
        }

        public void mutply(int times) {
            this.num = this.num * times;
        }
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        s.countOfAtoms("H2O");
    }
}
