package Data;

import java.util.Calendar;

/**
 * Created by solitude on 2017/2/7.
 *
 * 获取某一年中2月的天数
 */
public class CalendaDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        showDays(2020);
    }
    public static void showDays(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        show_date(calendar);
    }
    public static void show_date(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String week = getWeek(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(year + "年" + month + "月" + day + "日" + week);
    }
    public static String getWeek(int i) {
        String week[] = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return week[i];
    }
}
