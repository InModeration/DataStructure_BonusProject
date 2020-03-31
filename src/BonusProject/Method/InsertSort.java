package BonusProject.Method;

public class InsertSort {
    /**
     * 插入排序(对数组的前n个元素进行排序)
     * i从第二个元素开始遍历，前i - 1 个元素已经排序完成
     * 将其插入至前i - 1个元素当中，利用j与j - 1比较，将该元素“下沉”至合适的位置
     * @param data  要排序的数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void insertSort(int data[], int left, int right)
    {
        if (left < 0 || right >= data.length || left >= right)
            return;
        else {
            for (int i = left + 1; i <= right; i++)
                for (int j = i; (j > left) && (data[j-1] > data[j]); j--)
                        Swap.swap(data, j - 1, j);
            // to test the method if has run
            // System.out.println("insertSort has run");
        }
    }
}
