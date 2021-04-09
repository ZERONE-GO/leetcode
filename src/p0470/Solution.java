package p0470;

class Solution extends SolBase {
    public int rand10() {
        int value = (rand7() - 1) * 7 + rand7();

        while (value > 40) {
            value = (rand7() - 1) * 7 + rand7();
        }
        return 1 + value % 10;
    }
}
