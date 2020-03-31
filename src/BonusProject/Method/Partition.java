package BonusProject.Method;

public class Partition {
    /**
     * get the index of two partitions
     * @param data  处理的数组
     * @param left  左下标
     * @param right 右下标
     * @param pivot 进行比较的枢值
     * @return
     */
    public static int partition(int[] data, int left, int right, int pivot) {
        /**
         * i : left pointer
         * j : right pointer
         * left elements of pivot is lower
         * right elements of pivot is higher or equal
         */
        int i = left;
        int j = right;
        // 对有大于等于2个元素的划分进行继续分划
        while (i < j) {
            while ((i < j) && data[i] < pivot) i++;
            while ((i < j) && data[j] >= pivot) j--;
            Swap.swap(data, i, j);
        }
        return i;
    }
}
