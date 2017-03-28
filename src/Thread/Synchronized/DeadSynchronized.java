package Thread.Synchronized;

/**
 * Created by solitude on 2017/3/28.
 *
 * //死锁的问题：处理线程同步容易出现问题
 * //不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己的同步资源，就形成了线程的死锁
 */
public class DeadSynchronized {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args){
        new Thread(){
            public void run(){
                synchronized(sb1){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized(sb2){
                        sb2.append("B");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                synchronized(sb2){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("C");
                    synchronized(sb1){
                        sb2.append("D");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
    }
}
