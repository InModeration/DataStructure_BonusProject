package BonusProject.OptimizedOne;

import BonusProject.Method.InsertSort;
import BonusProject.Method.Partition;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

public class InsertAndQuickSort implements getRunTime {
    /**
     *
     * @param data  要进行排序的数组
     * @param left  划分后数组的左下标
     * @param right 划分后数组的右下标
     */
    public static void quickSort(int data[], int left, int right)
    {
        // 左右下标重合后，则划分至少有两个元素
        // 少于两个后，停止对子序列的排序
        if (left >= right)  return;

        // 找到该序列中的pivot下标并记录值
        int pivotIndex = findPivot(left, right);
        int pivot = data[pivotIndex];
        // 将pivot与末尾元素交换
        Swap.swap(data, right, pivotIndex);
        // 获取下标并将pivot与该处交换
        int index = Partition.partition(data, left, right, pivot);
        Swap.swap(data, index, right);

        // 当分划的元素个数小于等于10时
        // 使用插入排序而不是继续递归
        if ((index - 1 - left) < 10)
            InsertSort.insertSort(data, left, index - 1);
        else
            quickSort(data, left, index - 1);

        if ((right - index - 1) < 10)
            InsertSort.insertSort(data, index + 1, right);
        else
            quickSort(data, index + 1, right);
    }
    // 取pivot为序列中最中间的元素
    private static int findPivot(int left, int right)
    {
        return (left + right) / 2;
    }

    @Override
    public long getRunTime(int[] data) {
        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    // 交换数组中两元素的位置

}
