package Array;

/**
 * Created by solitude on 2017/1/4.
 */
public class DoubleArrayDemo {
    public static void main(String[] args){
        int arr[][] = new int[4][5];
        int arr2[][] = new int[3][];
        arr2[0] = new int[5];
        arr2[1] = new int[4];
        arr2[2] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }  
}
