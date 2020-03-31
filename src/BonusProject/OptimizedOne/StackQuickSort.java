package BonusProject.OptimizedOne;

import BonusProject.Method.Partition;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

import java.util.Stack;

public class StackQuickSort implements getRunTime {
    // stack用于存储下标
    private static Stack<Integer> stack = new Stack<>();

    /**
     * 利用栈进行快速排序
     * 利用循环而不是递归
     * （递归的实质就是利用栈循环）
     * @param data  要排序的数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort(int[] data, int left, int right) {

        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            // right后进栈，则其应该先出栈
            right = stack.pop();
            left = stack.pop();
            int pivotIndex = findPivot(left, right);
            int pivot = data[pivotIndex];
            Swap.swap(data, pivotIndex, right);
            int index = Partition.partition(data, left, right, pivot);
            Swap.swap(data, index, right);
            //左子序列
            if((index - 1) > left)
            {
                // 保证左下标先进栈， 右下标后进栈
                stack.push(left);
                stack.push(index - 1);
            }
            //右子序列
            if((index + 1) < right)
            {
                // 保证左下标先进栈， 右下标后进栈
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }
    private static int findPivot(int left, int right) {
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
