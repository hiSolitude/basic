package Regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by solitude on 2017/2/14.
 */
public class RegexTest {
    public static void main(String[] args) throws IOException{
        ArrayList<String> list = getMailsByWeb();
        for (String l : list) {
            System.out.println(l);
        }
    }
    //本地爬
    public static ArrayList<String> getMails() throws IOException{
        //1.读取源文件
        BufferedReader bufr = new BufferedReader(new FileReader("D:\\demo.txt"));
        //2.对读取的数据进行规则的匹配，从中获取符合规则的数据
        String regex = "[\\w&&[^_]]\\w+@\\w+(\\.\\w+)+";
        ArrayList<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        String line = null;
        while ((line=bufr.readLine()) != null){
            Matcher m = p.matcher(line);
            while (m.find()){
                //3.将符合规则的数据存储到集合中
                list.add(m.group());
            }
        }
            return list;
    }

    //网页上
    public static ArrayList<String> getMailsByWeb() throws IOException{
        URL url = new URL("http://www.163.com/");
        BufferedReader bufr = new BufferedReader(new InputStreamReader(
            url.openStream()));
        // 2，对读取的数据进行规则的匹配，从中获取符合规则的数据
        String regex = "[\\w&&[^_]]\\w+@\\w+(\\.\\w+)+";
        ArrayList<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        String line = null;
        while ((line = bufr.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                // 3，将符合规则的数据存储到集合中。
                list.add(m.group());
            }
        }
        return list;
    }
}
