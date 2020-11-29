package p1114;

class Foo {

    private boolean isFirst = false;
    
    private boolean isSecond = false;
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while(isFirst) {
                wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            isFirst = true;
            notifyAll();
        }
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while(!isFirst) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecond = true;
            notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while(!isSecond) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            isFirst = false;
            isSecond = false;
            notifyAll();
        }
    }
}