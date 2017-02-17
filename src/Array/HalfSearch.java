package Array;

/**
 * Created by solitude on 2017/1/4.
 *
 * 二分查找法（折半查找法）：
 * 前提：数组必须是有序的
 *
 */
public class HalfSearch {
    public static int halfSearch(int arr[],int key) {
        int max,min,mid;
        min=0;
        max=arr.length-1;
        mid=(max+min)/2;
        while(key!=arr[mid])
        {
            if(key>arr[mid])
                min=mid+1;
            else
                max=mid-1;
            if(max<min)
                return -1;
            mid=(max+min)/2;
        }
        return mid;
    }
}
