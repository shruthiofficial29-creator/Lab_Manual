import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release(); // Signal thread 2 to run
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire(); // Wait for thread 1
        printSecond.run();
        s3.release(); // Signal thread 3 to run
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire(); // Wait for thread 2
        printThird.run();
    }
}
