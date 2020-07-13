package concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author zerodsLyn
 * created on 2020/7/12
 */
public class PrintInOrder {
    CountDownLatch count1 = new CountDownLatch(1);
    CountDownLatch count2 = new CountDownLatch(1);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        count1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        count2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
