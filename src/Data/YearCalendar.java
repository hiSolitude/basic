package Data;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by solitude on 2017/2/7.
 *
 * 万年历
 */
public class YearCalendar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("************【欢迎使用万年历】************");
        System.out.println("请输入年份:");
        int year = scan.nextInt();
        System.out.println("请输入月份:");
        int month = scan.nextInt();
        printCalendar(year, month);
    }
    public static void printCalendar(int year, int month) {
        Calendar c = Calendar.getInstance();
        int num = getTotalDays(year, month);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("-------------【" + year + "年" + month+ "月日历】--------------------");
        System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        int weekDay = c.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 0; i < weekDay; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < num; i++) {
            System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            if (c.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }
            c.add(Calendar.DAY_OF_WEEK, 1);
        }
    }


    public static int getTotalDays(int year, int month) {
        if (month > 12 || month < 1) {
            throw new RuntimeException("月份不正确!");
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (isRunYear(year)) {
            return 29;
        } else {
            return 28;
        }
    }


    public static boolean isRunYear(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
