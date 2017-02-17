package Array;

/**
 * Created by solitude on 2017/1/4.
 */
public class SortDemo {
    //选择排序
    public int[] selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        return arr;
    }
    //冒泡排序
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
    }
    //quick sort
    public static void quick(int arr[], int start, int end) {
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i < j) {
            // 从后往前比较
            for (; j > i; j--) {
                if (arr[j] < temp) {
                    arr[i] = arr[j];
                    i++;
                    break;
                }
            }
            for (; i < j; i++) {
                if (arr[i] > temp) {
                    arr[j] = arr[i];
                    j--;
                    break;
                }
            }
            arr[i] = temp;
            if (i > start + 1) {
                quick(arr, start, i - 1);
            }
            if (j < end - 1) {
                quick(arr, j + 1, end);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 34, 35, 18, 92, 46, 28, 55, 73, 64 };
        quick(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
