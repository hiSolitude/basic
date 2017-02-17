package Utils;

import java.security.MessageDigest;

/**
 * Created by solitude on 2017/2/9.
 *
 *       对字符串进行MD5加密
 */
public class MD5Utils {
    public final static String MD5(String s){
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
        try{
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j*2];
            int k = 0;
            for (int i = 0 ; i<j;i++){
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0>>>6 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args){
          String s = MD5("admin");
        System.out.println(s);
    }
}
