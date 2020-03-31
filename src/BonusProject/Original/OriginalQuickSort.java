package BonusProject.Original;

import BonusProject.Method.Partition;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

public class OriginalQuickSort implements getRunTime {

    /**
     *  枢值取划分最中间、递归实现的快速排序
     * @param data  进行操作的数组
     * @param left  左下标
     * @param right 右下标
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
        // 进行分划并且返回下标值
        int index = Partition.partition(data, left, right, pivot);
        Swap.swap(data, index, right);
        quickSort(data, left, index - 1);
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
}
