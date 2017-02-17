package Array;

/**
 * Created by solitude on 2017/1/4.
 *
 *      public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 *      从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
 *      参数
 *      src -- 这是源数组.
 *      srcPos -- 这是源数组中的起始位置。
 *      dest -- 这是目标数组。
 *      destPos -- 这是目标数据中的起始位置。
 *      length -- 这是一个要复制的数组元素的数目。
 */
public class ArraycopyDemo {
    public static void main(String[] args){
        // 声明并创建一个长度为5的 int 类型的数组
        int srcArray[] = {1,2,3,4,5};
        System.out.println("改变长度之前："+srcArray.length);

        // 改变数组长度
        // ①,创建一个新数组(在原有长度上 +10)
        int destArray[] = new int[srcArray.length+10];
        // ②,将 srcArray 中的值对应拷贝到 destArray 中
        System.arraycopy(srcArray,0,destArray,0,srcArray.length);
        // ③,将新数组赋给 srcArray
        srcArray = destArray;
        System.out.println("改变长度之后："+srcArray.length);
    }
}
