package Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by solitude on 2017/2/7.
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str_date1 = "2016-3-17";
        String str_date2 = "2016-4-6";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 自定应格式
        // dateFormat=DateFormat.getDateInstance();//系统带有的格式
        Date date1 = dateFormat.parse(str_date1);
        Date date2 = dateFormat.parse(str_date2);
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long time = time2 - time1;
        System.out.println(time / 1000 / 60 / 60 / 24);

    }


}
