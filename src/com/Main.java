package com;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cb= new CyclicBarrier(3,new Run());
        new Sportsman(cb);
        new Sportsman(cb);
        new Sportsman(cb);


    }
    static class Run extends Thread{
               @Override
        public void run(){
            System.out.println("Race is begun");
        }
    }
    static class Sportsman extends Thread{
        CyclicBarrier cb;

        public Sportsman(CyclicBarrier cb) {
            this.cb = cb;
            start();
        }

        @Override
        public void run(){
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
