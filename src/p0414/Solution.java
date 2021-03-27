package p0414;

public class Solution {

    public int thirdMax(int[] nums) {
        MaxHeap heap = new MaxHeap(3);
        for(int i = 0; i < nums.length; i++) {
            heap.push(nums[i]);
        }
        return heap.getThirdMax();
    }

    private class MaxHeap {
        private int[] heap;
        private int len;
        private int size;

        public MaxHeap(int size) {
            heap = new int[size];
            len = 0;
            this.size = size;
        }

        public void push(int num) {
            if (len < size) {
                for (int i = 0; i < len; i++) {
                    if (num == heap[i]) {
                        return;
                    } else if (num < heap[i]) {
                        int tmp = heap[i];
                        heap[i] = num;
                        num = tmp;
                    }
                }
                heap[len] = num;
                len++;
            } else {
                if (heap[0] >= num) {
                    return;
                } else {
                    for (int i = len - 1; i >= 0; i--) {
                        if (num == heap[i]) {
                            return;
                        } else if (num > heap[i]) {
                            int tmp = heap[i];
                            heap[i] = num;
                            num = tmp;
                        }
                    }
                }
            }
        }

        public int getThirdMax() {
            return len < size ? heap[len-1] : heap[0];
        }
    }

}
