package Thread.Synchronized;

/**
 * Created by solitude on 2017/3/27.
 * <p>
 * 使用继承Thread的方式来实现窗口售票系统
 * <p>
 * 重载SellTickets的构造方法，调用Thread的方法来为线程付名称
 * 存在线程安全问题
 * 使用同步锁来解决问题
 */

class SellTickets extends Thread {
    static int tickets = 100;
    static Object o = new Object();

    public void run() {
        while (true) {
//            synchronized (this) {//此处的this代表s1,s2,s3
            synchronized (o) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了票 ，票号为： " + tickets--);
                } else {
                    break;
                }
            }
        }
    }

    public SellTickets(String name) {
        super.setName(name);
    }
}

public class TestWindowsByThreadAndSy {
    public static void main(String[] args) {
        SellTickets s1 = new SellTickets("窗口1");
        s1.start();
        SellTickets s2 = new SellTickets("窗口2");
        s2.start();
        SellTickets s3 = new SellTickets("窗口3");
        s3.start();
    }
}
