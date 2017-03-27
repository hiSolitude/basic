package Thread;

/**
 * Created by solitude on 2017/3/27.
 *
 * 通过实现Runnable的方式来创建线程
 *
 * 实现Runnable的方法vs继承Thread的方法
 *      实现Runnable的方式更好一些
 * why?
 *      1、避免了java单继承的局想性
 *      2、如果多个线程要操作同一份资源（或数据），更适合使用实现的方式
 * 则，在共享数据的时候用Runnable
 */

    class PrintNum implements Runnable{
        public void run() {
            for (int i = 1; i<= 100;i++){
                if (i%2==0) {
                    System.out.println(Thread.currentThread().getName() +":"+ i);
                }
            }
        }
    }
public class TestRunnable {
    public static void main(String[] args){
        PrintNum p = new PrintNum();
        Thread t1 = new Thread(p);
        t1.start();
        Thread t2 = new Thread(p);
        t2.start();
    }
}
