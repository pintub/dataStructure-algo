package com.p2.contest;

/**
 * Print Starting from "1"
 *
 * One Thread should print odd numbers & other even numbers & both should print alternatively
 */
public class PrintOddEvenByAlternateThread {

    public static void main(String[] args) {
        BooleanObject bool = new BooleanObject();bool.isOdd = true;

        Thread oddThread = new Thread(new OddPrinter(bool)) ;
        Thread evenThread = new Thread(new EvenPrinter(bool)) ;

        oddThread.start();
        evenThread.start();
    }

    static class OddPrinter implements Runnable{

        private BooleanObject booleanObject;

        private int count = 1;

        public OddPrinter(BooleanObject booleanObject) {
            this.booleanObject = booleanObject;
        }

        @Override
        public void run() {
            for(int i = 1; i <= 10; i++) {
                synchronized (booleanObject) {
                    System.out.println("OddThread is here For:" + count);
                    while (!booleanObject.isOdd) {
                        try {
                            booleanObject.wait();
                        } catch (InterruptedException e) {
                            //TODO
                        }
                    }
                    System.out.println("OddThread:" + count);
                    count += 2;
                    booleanObject.isOdd = false;
                    booleanObject.notify();
                }
            }
        }
    }

    static class EvenPrinter implements Runnable{
        private BooleanObject booleanObject;
        private int count = 2;

        public EvenPrinter(BooleanObject booleanObject) {
            this.booleanObject = booleanObject;
        }

        @Override
        public void run() {
            for(int i = 1; i <= 10; i++) {
                System.out.println("EvenThread is here For:" + count);
                synchronized (booleanObject) {
                    while (booleanObject.isOdd) {
                        try {
                            booleanObject.wait();
                        } catch (InterruptedException e) {
                            //TODO
                        }
                    }

                    System.out.println("EvenThread:" + count);
                    count += 2;
                    booleanObject.isOdd = true;
                    booleanObject.notify();
                }
            }
        }
    }

    static class BooleanObject {
        public boolean isOdd;
    }
}