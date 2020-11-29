package p1114;

public class MyThread implements Runnable {

    private int command;

    private Foo foo;

    public MyThread(int cmd, Foo foo) {
        this.command = cmd;
        this.foo = foo;
    }

    @Override
    public void run() {
        switch (command) {
        case 1:
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            break;
        case 2:
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;
        case 3:
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            break;
        default:
            break;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Foo foo = new Foo();
        MyThread first = new MyThread(1, foo);
        MyThread second = new MyThread(2, foo);
        MyThread third = new MyThread(3, foo);

        new Thread(third).start();
        new Thread(second).start();
        new Thread(first).start();

    }

}
