package BonusProject.OptimizedTwo;

import BonusProject.Method.*;
import BonusProject.OptimizedThree.InsertPivotAndStack;

public class PivotAndInsert implements getRunTime {
    /**
     *  use insert sort and better pivots to optimize the quick sort
     * @param data  进行操作的数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort(int[] data, int left, int right) {
        if (left >= right)  return;

        // 优化的获取枢值方法
        int pivotIndex = Pivot.findBetterPivot(data, left, right);
        int pivot = data[pivotIndex];
        // 交换枢值和右值
        Swap.swap(data, pivotIndex, right);
        // 获取划分并交换枢值位置
        int index = Partition.partition(data, left, right, pivot);
        Swap.swap(data, index, right);

        // 根据划分大小决定使用插入排序还是快速排序
        if ((index - 1 - left) < 10) InsertSort.insertSort(data, left, index - 1);
        else quickSort(data, left, index - 1);

        if ((right - index - 1) < 10)   InsertSort.insertSort(data, index + 1, right);
        else quickSort(data, index + 1, right);
    }
    @Override
    public long getRunTime(int[] data) {
        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
