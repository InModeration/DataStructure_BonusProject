package BonusProject.OptimizedThree;

import BonusProject.Method.*;

import java.util.Stack;

public class InsertPivotAndStack implements getRunTime {
    // store the indexes
    private static Stack<Integer> stack = new Stack<>();
    /**
     * 使用三种优化策略后的快速排序
     * @param data  进行操作的数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort(int[] data, int left, int right) {
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            // make sure the right order of pop()
            right = stack.pop();
            left = stack.pop();

            // get the better pivotIndex and pivot
            int pivotIndex = Pivot.findBetterPivot(data, left, right);
            int pivot = data[pivotIndex];
            Swap.swap(data, pivotIndex, right);
            // get the partition
            int index = Partition.partition(data, left, right, pivot);
            Swap.swap(data, index, right);

            /**
             * 元素个数 < 2, 停止循环
             * 元素个数 >= 2  && <= 10， 使用插入排序
             * else， 继续入栈并循环
             */
            // 左划分的元素个数
            int leftNum = index - left;
            if (leftNum >= 2 && leftNum <= 10) InsertSort.insertSort(data, left, index - 1);
            else if (leftNum > 10) {
                stack.push(left);
                stack.push(index - 1);
            }
            // 右划分的元素个数
            int rightNum = right - index;
            if (rightNum >= 2 && rightNum <= 10)    InsertSort.insertSort(data, index + 1, right);
            else if (rightNum > 10) {
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
