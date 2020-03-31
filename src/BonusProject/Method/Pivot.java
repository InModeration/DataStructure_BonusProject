package BonusProject.Method;

public class Pivot {
    /**
     * 选出数组分划中最左、中间、最右值中居中值的下标
     * @param data  进行操作的数组
     * @param left  左下标
     * @param right 右下标
     * @return      居中值的下标
     */
    public static int findBetterPivot(int[] data, int left, int right) {
        int mid = (left + right) / 2;
        if (data[left] > data[mid])//left > mid
        {
            if (data[left] < data[right])//mid < left < right
                return left;
            else//left > mid,left > right
            {
                if (data[right] > data[mid])//mid < right < left
                    return right;
                else//right < mid < left
                    return mid;
            }
        }
        else//left < mid
        {
            if (mid > right)//left < mid < right
                return mid;
            else//mid < left,mid < right
            {
                if (left < right)//mid < left < right
                    return left;
                else
                    return right;
            }
        }
    }
}
