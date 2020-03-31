package BonusProject.Method;

public class Swap {
    /**
     * 根据下标直接交换数组中的两个元素
     * @param data  进行操作的数组
     * @param i     元素的下标
     * @param j     元素的下标
     */
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 直接交换两个数据的值
     * @param firstEle
     * @param secondEle
     */
    /*public static void swap(int firstEle, int secondEle) {
        int temp = firstEle;
        firstEle = secondEle;
        secondEle = temp;
    }*/

}
