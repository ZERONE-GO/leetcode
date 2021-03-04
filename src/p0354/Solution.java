package p0354;

import java.util.Arrays;

public class Solution {

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a1, a2) -> {
			if (a1[0] == a2[0] && a1[1] == a2[1]) {
				return 0;
			} else if (a1[0] > a2[0] || (a1[0] == a2[0] && a1[1] > a2[1])) {
				return 1;
			} else {
				return -1;
			}
		});

		int[] max = new int[envelopes.length];
		max[0] = 1;
		for (int i = 1; i < envelopes.length; i++) {
			max[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					if(max[i] < max[j] + 1) {
						max[i] = max[j] + 1;
					}
				}
			}
		}

		int result = 0;
		for (int i = 0; i < envelopes.length; i++) {
			if (result < max[i]) {
				result = max[i];
			}
		}

		return result;
	}

	public static void main(String args[]) {
		int envs[][] = {{46,89},{50,53},{52,68},{72,45},{77,81}};
		Solution s = new Solution();
		System.out.println(s.maxEnvelopes(envs));
	}

}
