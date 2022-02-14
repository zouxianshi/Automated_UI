package cn.crow.webui.AW.common;

import lombok.SneakyThrows;

/**
 * @author xiaoyang
 * @date 2021/12/20
 * @time 18:37
 * @since JDK 1.8
 */
public class Test {

    private static volatile boolean flag = true;

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        MyThread threadA = new MyThread("A");
        threadA.start();
        MyThread threadB = new MyThread("B");
        threadB.start();
        MyThread threadC = new MyThread("C");
        threadC.start();
        MyThread threadD = new MyThread("D");
        threadD.start();

        Thread.sleep(10000L);
        threadC.setOpen(true);

        Thread.sleep(10000L);
        threadC.setOpen(false);
        Thread.sleep(30000L);
    }

    static class MyThread extends Thread{

        private boolean open = false;

        public MyThread(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {

                    if (flag) {
                        System.out.println(getName() + "正在执行");
                        Thread.sleep(1000L);

                        if (open) {
                            System.out.println(getName() + "监听到");
                            flag = false;
                            Thread.sleep(30000L);
                            flag = true;
                            System.out.println(getName() + "监听结束");
                            synchronized (lock) {
                                lock.notifyAll();
                            }
                        }
                        System.out.println(getName() + "结束执行");
                    } else {
                        synchronized (lock) {
                            System.out.println(getName() + "暂停监听");
                            lock.wait();
                        }
                    }
                }

            }


        //监听信号
        public void setOpen(boolean open) {
            this.open = open;
        }
    }

}
