package com.ssn.test;

public class ThreadAppWait {

    public static void main(String[] args) {

        ThreadAppWait.Store store=new ThreadAppWait.Store();
        ThreadAppWait.Producer producer = new ThreadAppWait.Producer(store);
        ThreadAppWait.Consumer consumer = new ThreadAppWait.Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    // Класс Магазин, хранящий произведенные товары
    static class Store{
        private int product=0;
        public synchronized void get() {
            while (product<1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }
        public synchronized void put() {
            while (product>=1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notifyAll();
        }
    }
    // класс Производитель
    static class Producer implements Runnable{

        ThreadAppWait.Store store;
        Producer(ThreadAppWait.Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 60000; i++) {
                store.put();
                Thread.yield();
            }
        }
    }
    // Класс Потребитель
    static class Consumer implements Runnable{

        ThreadAppWait.Store store;
        Consumer(ThreadAppWait.Store store){
            this.store=store;
        }
        public void run(){
            for (int i = 1; i < 60000; i++) {
                store.get();
                Thread.yield();
            }
        }
    }
}
