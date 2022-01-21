package cn.crow.webui.entity;

public class Demo1 {
    private volatile  int flag = 1;

    public void do1(){
        String name = Thread.currentThread().getName();
        System.out.printf("线程"+name+"执行do1"+"\n");

    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        for (int i=1;i<=10;i++){
            new Thread(()->{
                demo1.do1();
            },i+"").start();
        }
    }
}
