package cn.crow.webui.control.baseComponent;

import lombok.SneakyThrows;

public class DemoThread extends Thread{
    private static volatile boolean stop = false;
    private static volatile Object lock = new Object();

    @SneakyThrows
    @Override
    public void run() {
//        while(!stop){
            System.out.println(Thread.currentThread().getName()+"线程进来了");
            Thread.sleep(10000);
            stop = true;
            System.out.println(Thread.currentThread().getName()+"线程结束了");
//        }
    }

    public static void main(String[] args) {
        for (int i =1;i<=10;i++){
            DemoThread demoThread = new DemoThread();
            demoThread.setName(i+"");
            demoThread.start();
        }
    }

}
