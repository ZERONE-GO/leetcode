package p1116;

class ZeroEvenOdd {
    private int n;

    private Object lock = new Object();

    private volatile int i = 1;

    private volatile int status = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                while (status != 0 && i <= n) {
                    lock.wait();
                }
                if(i <= n) {
                    printNumber.accept(0);
                }
                this.status = (i&1) == 1 ? 1 : 2;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while(i <= n) {
                while (status != 2 && i <= n) {
                    lock.wait();
                }
                if(i<=n) {
                    printNumber.accept(i);
                }
                i ++;
                this.status = 0;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while(i <= n) {
                while (status != 1 && i <= n) {
                    lock.wait();
                }
                if(i<=n) {
                    printNumber.accept(i);
                }
                i ++;
                this.status = 0;
                lock.notifyAll();
            }
        }
    }
}
