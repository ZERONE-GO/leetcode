package p0264;

public class Solution {

    public int nthUglyNumber(int n) {
        long[] uglyNumbers = new long[1691];
        long[] factors = { 2, 3, 5 };
        uglyNumbers[1] = 1;

        return (int)calcUglyNumber(uglyNumbers, factors, n);
    }

    public long calcUglyNumber(long[] numbers, long[] factors, int n) {
        if (numbers[n] != 0) {
            return numbers[n];
        }

        long prev = calcUglyNumber(numbers, factors, n - 1);

        numbers[n] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < factors.length; j++) {
                long result = calcUglyNumber(numbers, factors, i) * factors[j];
                if (result > prev && result < numbers[n]) {
                    numbers[n] = result;
                }
            }
        }
        return numbers[n];
    }
}
