package BonusProject.OptimizedOne;

import BonusProject.Method.Partition;
import BonusProject.Method.Pivot;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

public class BetterPivotQuickSort implements getRunTime {

    public static void quickSort(int[] data, int left, int right) {
        // 左右下标重合后，则划分至少有两个元素
        // 少于两个后，停止对子序列的排序
        if (left >= right)  return;

        // 找到该序列中的pivot下标并记录值
        int pivotIndex = Pivot.findBetterPivot(data, left, right);
        int pivot = data[pivotIndex];
        // 将pivot与末尾元素交换
        Swap.swap(data, right, pivotIndex);
        // 进行分划并且返回下标值
        int index = Partition.partition(data, left, right, pivot);
        Swap.swap(data, index, right);
        quickSort(data, left, index - 1);
        quickSort(data, index + 1, right);
    }

    @Override
    public long getRunTime(int[] data) {
        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
