package p0338;

public class Solution {
	
	public int[] countBits(int num) {
		int[] result;
		if (num == 0) {
			result = new int[1];
			result[0] = 0;
		} else if (num == 1) {
			result = new int[2];
			result[0] = 0;
			result[1] = 1;
		} else {
			result = new int[num + 1];
			result[0] = 0;
			result[1] = 1;
			int cap = 2;
			int index = 2;
			while (index <= num) {
				for (int i = 0; i < cap && index <= num; i++) {
					result[index] = result[index - cap + i] + 1;
					index++;
				}
				cap = cap << 1;
			}
		}
		return result;
	}

}
