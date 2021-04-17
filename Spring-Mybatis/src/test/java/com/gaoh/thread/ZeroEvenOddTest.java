package com.gaoh.thread;

import java.util.function.IntConsumer;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/21 23:48
 * @Version: 1.0
 */
public class ZeroEvenOddTest {

    private int n;
    private volatile int num = 0;

    public ZeroEvenOddTest(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                if (num != 0) {
                    wait();
                }
                printNumber.accept(0);
                this.num = 1;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                synchronized (this) {
                    while (num != 2) {
                        wait();
                    }
                    printNumber.accept(i);
                    num = 0;
                    notifyAll();
                }
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                synchronized (this) {
                    if (num != 1) {
                        wait();
                    }
                    printNumber.accept(i);
                    num = 0;
                    notifyAll();
                }
            }
        }
    }
}
