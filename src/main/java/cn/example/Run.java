package cn.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Run {

    private static volatile int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread() {

            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 1) {
                        conditionA.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("ThreadA " + (i+1));
                    }
                    nextPrintWho = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
        Thread threadB = new Thread() {

            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 2) {
                        conditionB.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("ThreadB " + (i+1));
                    }
                    nextPrintWho = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
        Thread threadC = new Thread() {

            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 3) {
                        conditionC.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("ThreadC " + (i+1));
                    }
                    nextPrintWho = 1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
        for(int i=0; i<5; i++) {
            new Thread(threadA).start();
            new Thread(threadB).start();
            new Thread(threadC).start();
        }
    }

}