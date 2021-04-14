package p1825;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MKAverage {
    
    private List<Integer> list;
    
    private int m;
    
    private int k;
    
    public MKAverage(int m, int k) {
        list = new ArrayList<Integer>(m);
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        list.add(num);
    }
    
    public int calculateMKAverage() {
        if(list.size() < m) {
            return -1;
        }
        PriorityQueue<Integer> topQueue = new PriorityQueue<>((a, b) -> {
            return b -a;
        });
        PriorityQueue<Integer> downQueue = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        int sum = 0;
        
        for(int i=list.size()-1; i >= list.size() - m; i --) {
            sum += list.get(i);
            if(topQueue.size() < k) {
                topQueue.add(list.get(i));
            } else {
                if(list.get(i) > topQueue.peek()) {
                    topQueue.poll();
                    topQueue.add(list.get(i));
                }
            }
            
            if(downQueue.size() < k) {
                downQueue.add(list.get(i));
            } else {
                if(list.get(i) < downQueue.peek()) {
                    downQueue.poll();
                    downQueue.add(list.get(i));
                }
            }
        }
        
        while(!topQueue.isEmpty()) {
            sum -= topQueue.poll();
        }
        
        while(!downQueue.isEmpty()) {
            sum -= downQueue.poll();
        }
        
        return sum / (m - 2 * k);
    }
    
    public static void main(String args[]) {
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(3);
        mk.addElement(1);
        //mk.calculateMKAverage();
        mk.addElement(10);
        mk.calculateMKAverage();
    }

}
