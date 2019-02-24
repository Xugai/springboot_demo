package com.example.demo;

/**
 * Created by rabbit on 2018/5/24.
 */
public class Demo {

    public static void main(String [] args){
        new Thread(new Thread1()).start();
        try{
            Thread.sleep(5000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (Demo.class){
                System.out.println("Thread1 enter......");
                System.out.println("Thread1 wait......");
                try{
                    /**
                     * 调用object级别的wait方法，线程会放弃对象锁，进入等待锁定池
                     */
                    Demo.class.wait();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                System.out.println("Thread1 continue it's task......");
                System.out.println("Thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run(){
            synchronized (Demo.class){
                System.out.println("Thread2 enter......");
                System.out.println("Thread2 is sleep......");
                /**
                 * 通知前面被剥夺对象锁的Thread1，让其从等待锁定池重新进入对象锁定池
                 */
                Demo.class.notify();
                try{
                    /**
                     * 调用Thread级别的sleep方法，线程会进入睡眠状态，但与wait方法不同的是，这时线程
                     * 不会被剥夺对象锁，它会一直持有，直到它从睡眠苏醒，执行完它自己的代码之后才会释放
                     * 对象锁。
                     */
                    Thread.sleep(5000);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                System.out.println("Thread2 continue......");
                System.out.println("Thread2 is over!!!  ");
            }
        }
    }
}
