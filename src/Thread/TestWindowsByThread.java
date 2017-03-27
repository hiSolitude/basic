package Thread;

/**
 * Created by solitude on 2017/3/27.
 * <p>
 * 使用继承Thread的方式来实现窗口售票系统
 *
 * 重载SellTickets的构造方法，调用Thread的方法来为线程付名称
 */

class SellTickets extends Thread {
    static int tickets = 100;

    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了票 ，票号为： " + tickets--);
            } else {
                break;
            }
        }
    }
    public SellTickets(String name) {
        super.setName(name);
    }
}

public class TestWindowsByThread {
    public static void main(String[] args) {
        SellTickets s1 = new SellTickets("窗口1");
        s1.start();
        SellTickets s2 = new SellTickets("窗口2");
        s2.start();
        SellTickets s3 = new SellTickets("窗口3");
        s3.start();
    }
}
