package Collection.List.RabbitQuestion;

import java.util.Scanner;

/**
 * Created by solitude on 2017/2/8.
 *
 * 有一户农家买了一对小兔子，
 * 小兔子长到三个月的时候开始生一对小兔子，
 * 以后每个月生一对小兔子， 小兔子涨到三个月又开始生小兔子，
 * 以此推类，要求编写程序，
 * 输入从第一对小兔子买回来后经过几个月得到几对小兔子
 */
public class Rabbit {
    public static void main(String[] args){
        System.out.println("请输入月份：");
        Scanner scan = new Scanner(System.in);
        while (true){
                int month = scan.nextInt();
                System.out.println(month+"月后兔子有："+getRabbitNum(month)+"对");
        }
    }

    public static int getRabbitNum(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return getRabbitNum(month - 1) + getRabbitNum(month - 2);
        }
    }

}
