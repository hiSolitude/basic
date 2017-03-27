package Thread.Synchronized;

/**
 * Created by solitude on 2017/3/27.
 * <p>
 * 使用实现Runnable的方式来实现窗口售票系统
 *
 * 1、线程安全问题存在的原因
 *      由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题
 * 2、如何解决线程的安全问题
 *      必须让一个线程操作共享数据完毕之后，其他线程才有机会参与共享数据的操作
 * 3、java如何实现线程的安全：线程的同步机制
 *
 *      方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码块（即为操作共享数据的代码）
 *      }
 *      1、共享数据：多个线程共同操作的同一个数据（变量）
 *      2、同步监视器：由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里被同步的代码。俗称：锁
 *      要求：所有的线程必须共用同一把锁
 *      注：在实现的方式中，考虑同步的话，可以使用this来充当锁。但是在继承的方式中，慎用this
 *          要明白this代表什么
 *      方式二：同步方法
 */

class SellTickets2 implements Runnable {
    int tickets = 100;
//    Object o = new Object();
    public void run() {
        while (true) {
            synchronized (this) {//此处的this代表s1
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
}

public class TestWindowsByRunnableAndSy {
    public static void main(String[] args) {
        SellTickets2 s1 = new SellTickets2();

        Thread t1 = new Thread(s1);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(s1);
        t2.setName("窗口2");
        t2.start();
        Thread t3 = new Thread(s1);
        t3.setName("窗口3");
        t3.start();
    }
}
