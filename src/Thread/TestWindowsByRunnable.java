package Thread;

/**
 * Created by solitude on 2017/3/27.
 * <p>
 * 使用实现Runnable的方式来实现窗口售票系统
 *
 * 存在线程安全问题
 * 在线程sleep()之后，会放大问题
 * 可以使用同步锁方式来解决问题
 */

class SellTickets1 implements Runnable {
    int tickets = 100;

    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了票 ，票号为： " + tickets--);
            } else {
                break;
            }
        }
    }
}

public class TestWindowsByRunnable {
    public static void main(String[] args) {
        SellTickets1 s1 = new SellTickets1();

        Thread t1 = new Thread(s1);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(s1);
        t2.start();
        Thread t3 = new Thread(s1);
        t3.start();
    }
}
