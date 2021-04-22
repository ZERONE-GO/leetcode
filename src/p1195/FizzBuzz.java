package p1195;

public class FizzBuzz {
    private int n;

    private Object lock = new Object();

    private volatile int status = 0;

    private boolean fizz = false;

    private boolean buzz = false;

    private volatile int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                while (status != 3 && i <= n) {
                    lock.wait();
                }

                if (i > n) {
                    break;
                }

                printFizz.run();
                fizz = false;
                i++;
                status = 0;
                lock.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                while (status != 5 && i <= n) {
                    lock.wait();
                }

                if (i > n) {
                    break;
                }

                printBuzz.run();
                buzz = false;
                i++;
                status = 0;
                lock.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                while (status != 15 && i <= n) {
                    lock.wait();
                }

                if (i > n) {
                    break;
                }

                printFizzBuzz.run();
                buzz = false;
                fizz = false;
                i++;
                status = 0;
                lock.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                while (status != 0) {
                    lock.wait();
                }
                
                if(i > n) {
                    break;
                }
                
                if (i % 3 == 0) {
                    fizz = true;
                }
                if (i % 5 == 0) {
                    buzz = true;
                }

                if (fizz && buzz) {
                    status = 15;
                    lock.notifyAll();
                } else if (fizz && !buzz) {
                    status = 3;
                    lock.notifyAll();
                } else if (!fizz && buzz) {
                    status = 5;
                    lock.notifyAll();
                } else {
                    printNumber.accept(i);
                    i++;
                    status = 0;
                    lock.notifyAll();
                }
            }
        }
    }
}
