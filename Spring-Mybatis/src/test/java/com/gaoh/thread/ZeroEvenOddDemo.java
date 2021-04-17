package com.gaoh.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/21 23:48
 * @Version: 1.0
 */
public class ZeroEvenOddDemo {

    public ReentrantLock lock = new ReentrantLock();

    Condition zeroCondition = lock.newCondition();
    Condition evenCondition = lock.newCondition();
    Condition oddCondition = lock.newCondition();

    private int n;
    private volatile int num = 0;

    public ZeroEvenOddDemo(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            if (num != 0) {
                zeroCondition.await();
            }
            printNumber.accept(0);
            this.num = 1;
            oddCondition.signal();
            evenCondition.signal();
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                lock.lock();
                while (num != 2) {
                    evenCondition.await();
                }
                printNumber.accept(i);
                num = 0;
                zeroCondition.signal();
                lock.unlock();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                lock.lock();
                while (num != 1) {
                    oddCondition.await();
                }
                printNumber.accept(i);
                num = 0;
                zeroCondition.signal();
                lock.unlock();
            }
        }
    }
}
