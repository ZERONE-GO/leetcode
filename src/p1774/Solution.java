package p1774;

public class Solution {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = baseCosts.length;
        int m = toppingCosts.length;

        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int price = closest(toppingCosts, 0, m, baseCosts[i], target);
            if(Math.abs(price-target) < diff) {
                diff = Math.abs(price-target);
                result = price;
            } else if(Math.abs(price-target) == diff) {
                result = result < price ? result : price;
            }
            
        }
        return result;
    }

    private int closest(int[] toppingCosts, int index, int m, int price, int target) {
        if (index == m) {
            return price;
        }
        int result = 0;
        int a = closest(toppingCosts, index + 1, m, price, target);
        int b = closest(toppingCosts, index + 1, m, price + toppingCosts[index], target);
        if(Math.abs(target - a) < Math.abs(target - b)) {
            result = a;
        } else if(Math.abs(target - a) == Math.abs(target - b)) {
            result = a < b ? a : b;
        } else {
            result = b;
        }
        int c = closest(toppingCosts, index + 1, m, price + toppingCosts[index] + toppingCosts[index], target);
        
        if(Math.abs(target - c) < Math.abs(target - result)) {
            result = c;
        } else if(Math.abs(target - c) == Math.abs(target - result)) {
            result = c < result ? c : result;
        } 
        return result;
    }

}
