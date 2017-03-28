package Thread.Synchronized;

/**
 * Created by solitude on 2017/3/28.
 * <p>
 * 生产者/消费者问题
 * 生产者（Productor）将产品交给店员（Clert），而消费者（Customer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员会叫生产者听一下
 * 如果店中有空位放产品了，再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下
 * 如果店中有产品了再通知消费者来取走产品
 * <p>
 * 分析：
 * 1、是否涉及到多线程的问题？是！生产者、消费者
 * 2、是否涉及到共享数据？是！产品的数量
 * 3、需要考虑线程的安全
 * 4、是否涉及到线程的通信？生产者消费者
 * <p>
 * 若库存不足或者库存过饱
 * 生产者只要生产一个，消费者即可唤醒线程进行消费
 * 消费者只要消费一个，生产者即可唤醒线程进行生产
 */
class Clerk {//店员
    int product;

    public synchronized void addProduct() {//生产产品
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName() + ":生产了第" + product + "个产品");
            notifyAll();
        }
    }

    public synchronized void consumeProduct() {//消费产品
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":消费了第" + product + "个产品");
            product--;
            notifyAll();
        }
    }
}

class Producer implements Runnable { //生产者
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产者开始生产产品");
        while (true) {
            clerk.addProduct();
        }
    }
}

class Consumer implements Runnable {//消费者
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者开始消费产品");
        while (true) {
            clerk.consumeProduct();
        }
    }

}

public class TestProduceConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread t1 = new Thread(producer);//一个生产者的线程
        Thread t3 = new Thread(producer);//第二个生产者的线程
        Thread t2 = new Thread(consumer);//一个消费者的线程

        t1.setName("生产者1");
        t3.setName("生产者2");
        t2.setName("消费者1");

        t1.start();
        t2.start();
        t3.start();
    }
}
