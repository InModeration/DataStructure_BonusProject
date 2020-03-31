package BonusProject.OptimizedTwo;

import BonusProject.Method.InsertSort;
import BonusProject.Method.Partition;
import BonusProject.Method.Swap;
import BonusProject.Method.getRunTime;

import java.util.Stack;

public class StackAndInsert implements getRunTime {
    // store the indexes
    private static Stack<Integer> stack = new Stack<>();

    /**
     *  使用栈循环代替递归方法
     *  并且在划分元素较少时使用插入排序代替快速排序
     * @param data  进行操作的数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort(int[] data, int left, int right) {
        stack.push(left);
        stack.push(right);

        // 进行循环
        while (!stack.isEmpty()) {
            // 确保左、右下标赋值正确
            right = stack.pop();
            left = stack.pop();

            // same operations
            int pivotIndex = findPivot(left, right);
            int pivot = data[pivotIndex];
            Swap.swap(data, pivotIndex, right);
            int index = Partition.partition(data, left, right, pivot);
            Swap.swap(data, index, right);

            /**
             * 元素个数 < 2, 停止循环
             * 元素个数 >= 2  && <= 10， 使用插入排序
             * else， 继续入栈并循环
             */
            // 左划分的元素个数
            int leftNum = index - left;
            if (leftNum < 2);
            else if (leftNum >= 2 && leftNum <= 10) InsertSort.insertSort(data, left, index - 1);
            else {
                stack.push(left);
                stack.push(index - 1);
            }
            // 右划分的元素个数
            int rightNum = right - index;
            if (rightNum < 2);
            else if (rightNum >= 2 && rightNum <= 10)    InsertSort.insertSort(data, index + 1, right);
            else {
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }
    private static int findPivot(int left, int right) {
        return (left + right)/2;
    }

    @Override
    public long getRunTime(int[] data) {
        long startTime = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
