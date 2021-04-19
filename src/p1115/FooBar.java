package p1115;

public class FooBar {

    private int n;

    private Object lock = new Object();

    private int status = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(status != 0) {
                    lock.wait();
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                status = 1;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(status != 1) {
                    lock.wait();
                }
                
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                status = 0;
                lock.notifyAll();
            }
        }
    }

}
