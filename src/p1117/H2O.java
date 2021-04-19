package p1117;

public class H2O {

    private Object lock = new Object();

    private volatile int h2 = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        synchronized (lock) {
            while (h2 >= 2) {
                lock.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h2++;
            lock.notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (h2 < 2) {
                lock.wait();
            }

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h2 = 0;
            lock.notifyAll();
        }
    }

}
