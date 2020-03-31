package BonusProject.OptimizedTwo;

import BonusProject.Method.Partition;
import BonusProject.Method.Pivot;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

import java.util.Stack;

public class PivotAndStack implements getRunTime {
    // store index
    private static Stack<Integer> stack = new Stack<>();

    /**
     * using stack and better pivot to implement the quick sort
     * @param data
     * @param left
     * @param right
     */
    public static void quickSort(int[] data, int left, int right) {
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            // 右下标后进栈，则其将先出栈
            right = stack.pop();
            left = stack.pop();
            // 获取枢值下标及其值并交换至划分的末尾
            int pivotIndex = Pivot.findBetterPivot(data, left, right);
            int pivot = data[pivotIndex];
            Swap.swap(data, pivotIndex, right);
            // 获取划分的下标,并将枢值交换至该下标处
            int index = Partition.partition(data, left, right, pivot);
            Swap.swap(data, index, right);
            /**
             * 判断是否可继续循环划分
             * 确保左下标先进栈， 右下标后进栈
             */
            if ((index - 1) > left) {
                // 左划分可以继续划分循环
                stack.push(left);
                stack.push(index - 1);
            }
            if ((index + 1) < right) {
                // 右划分可以继续划分循环
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }

    @Override
    public long getRunTime(int[] data) {
        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
