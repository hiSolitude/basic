package Collection.List;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by solitude on 2017/2/8.
 */
public class VectorDemo {
    public static void main(String[] args){
        Vector<String> v = new Vector<String>();
        v.addElement("java01");
        v.addElement("java02");
        v.addElement("java03");
        Enumeration<String> en = v.elements();
        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
    }
}
