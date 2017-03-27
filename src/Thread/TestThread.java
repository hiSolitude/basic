package Thread;

/**
 * Created by solitude on 2017/3/27.
 */
class PrintNum1 extends Thread{
    public void run(){
        for (int i = 1; i<= 100;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }
        }
    }
}

public class TestThread {
    public static void main(String[] args){
        PrintNum1 p1 = new PrintNum1();
        p1.start();
        PrintNum1 p2 = new PrintNum1();
        p2.start();
    }
}
