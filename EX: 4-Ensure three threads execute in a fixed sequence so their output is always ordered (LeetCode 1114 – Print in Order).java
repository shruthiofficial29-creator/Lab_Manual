import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");
        int[] launchOrder = {3, 1, 2};
        Thread[] threads = new Thread[3];
        for (int i = 0; i < launchOrder.length; i++) {
            int threadNum = launchOrder[i];
            if (threadNum == 1) {
                threads[i] = new Thread(() -> {
                    try {
                        foo.first(printFirst);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else if (threadNum == 2) {
                threads[i] = new Thread(() -> {
                    try {
                        foo.second(printSecond);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else if (threadNum == 3) {
                threads[i] = new Thread(() -> {
                    try {
                        foo.third(printThird);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
        System.out.print("Output: \"");
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\"");
    }
}

class Foo {
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);
    public Foo() {}
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}
