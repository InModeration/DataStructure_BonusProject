package BonusProject.Tester;

import BonusProject.Method.RandomNum;
import BonusProject.OptimizedOne.BetterPivotQuickSort;
import BonusProject.OptimizedOne.InsertAndQuickSort;
import BonusProject.OptimizedOne.StackQuickSort;
import BonusProject.OptimizedThree.InsertPivotAndStack;
import BonusProject.OptimizedTwo.PivotAndInsert;
import BonusProject.OptimizedTwo.PivotAndStack;
import BonusProject.OptimizedTwo.StackAndInsert;
import BonusProject.Original.OriginalQuickSort;

import java.util.*;

/**
 * tester on different versions of QuickSort
 */
public class Test {
    // define the number of the data and run times
    private static int size = 0;
    private static int times = 0;
    // scanner to get array size and run times
    private static Scanner arraySize = null;
    private static Scanner runTimes = null;
    // define ArrayList to store the run times
    private static ArrayList<Long> ori = new ArrayList<>();
    private static ArrayList<Long> stack = new ArrayList<>();
    private static ArrayList<Long> pivot = new ArrayList<>();
    private static ArrayList<Long> insert = new ArrayList<>();
    private static ArrayList<Long> pi_in = new ArrayList<>();
    private static ArrayList<Long> pi_sta = new ArrayList<>();
    private static ArrayList<Long> in_sta = new ArrayList<>();
    private static ArrayList<Long> pi_in_sta = new ArrayList<>();
    // define the array list to store array lists above
    private static Map<String, ArrayList<Long>> container = new HashMap<>();

    // 入口，构造器中实现了运行的所有方法
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
         // 获取数组大小
        size = getInfo(true);
        // 获取测试次数
        times = getInfo(false);
        try {
            // 搞过场
            System.out.println("请耐心等候······");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 根据接受到的数据进行排序
        run(size, times);
        // 展示结果
        show(size, times);
    }
    /**
     *  sub method of tester
     * @param which to make sure which data users need
     * @return      run_times or array_size
     */
    private static int getInfo(Boolean which) {
        int array_size = 0;
        int run_times = 0;
        /**
         * get the right input
         * accepted Integer only
         * Integer higher than 0 only
         */
        // to get the array size
        if (which) {
            do {
                if (arraySize == null)
                    System.out.println("请输入排序测试的数组元素个数：");
                else
                    System.out.println("输入有误，请重新输入！");
                arraySize = new Scanner(System.in);
                if (arraySize.hasNextInt()) {
                    array_size = arraySize.nextInt();
                    if (array_size <= 0) {
                        System.out.print("数组大小不能小于1 ！");
                        arraySize = null;
                        continue;
                    }
                    break;
                }
            } while (arraySize == null || !arraySize.hasNextInt());
            return array_size;
        }
        // to get the run times
        else {
            do {
                if (runTimes == null)
                    System.out.println("请输入要进行测试的次数：");
                else
                    System.out.println("输入有误，请重新输入！");
                runTimes = new Scanner(System.in);
                if (runTimes.hasNextInt()) {
                    run_times = runTimes.nextInt();
                    if (run_times <= 0) {
                        System.out.print("测试次数应该大于0 ！");
                        runTimes = null;
                        continue;
                    }
                    break;
                }
            } while (runTimes == null || !runTimes.hasNextInt());
            return run_times;
        }
    }

    /**
     *  sub method of tester
     * @param size  the number of numbers
     * @param times run times
     */
    private static void run(int size, int times) {
        int count = 0;
        // get the run time of seven quick sort
        while (count++ < times) {
            /**
             * create seven arrays
             * every one of them has the same size
             * and data in every array are all the same
             */
            int[] data_1 = new int[size];
            RandomNum randomNum = new RandomNum();
            for (int i = 0; i < size; i++) {
                data_1[i] = randomNum.getRandomNum();
            }
            int[] data_2 = data_1.clone();
            int[] data_3 = data_1.clone();
            int[] data_4 = data_1.clone();
            int[] data_5 = data_1.clone();
            int[] data_6 = data_1.clone();
            int[] data_7 = data_1.clone();
            int[] data_8 = data_1.clone();

            /**
             * run the eight quick sort methods
             * add the run time to their own array list
             */
            ori.add(new OriginalQuickSort().getRunTime(data_1));
            pivot.add(new BetterPivotQuickSort().getRunTime(data_2));
            insert.add(new InsertAndQuickSort().getRunTime(data_3));
            stack.add(new StackQuickSort().getRunTime(data_4));
            pi_in.add(new PivotAndInsert().getRunTime(data_5));
            pi_sta.add(new PivotAndStack().getRunTime(data_6));
            in_sta.add(new StackAndInsert().getRunTime(data_7));
            pi_in_sta.add(new InsertPivotAndStack().getRunTime(data_8));
        }
        // add array lists above into the container
        container.put("Original QuickSort :",ori);
        container.put("BetterPivot QuickSort :", pivot);
        container.put("Insert Combined QuickSort :", insert);
        container.put("Stack Based QuickSort :", stack);
        container.put("Insert and Pivot QuickSort :", pi_in);
        container.put("Pivot and Stack QuickSort :", pi_sta);
        container.put("Insert and Stack QuickSort :", in_sta);
        container.put("Insert Pivot and Stack QuickSort :", pi_in_sta);
    }

    /**
     * sub method of tester
     * to show the result of run time of different sorts
     * @param times run times
     * @param size  the size of data
     */
    private static void show(int size, int times) {
        int count = 0;
        long totalTime = 0;
        System.out.println("本轮测试共 " + times + " 次， 每次用于排序" +
                "测试的元素个数为 " + size + " 个");
        System.out.println("---------测试结果---------");
        while (count++ < times) {
            System.out.println("     ----第" + count + "次----     ");
            System.out.println("Original QuickSort:" + ori.get(count - 1) + " ms\n");
            System.out.println("Better Pivot QuickSort:" + pivot.get(count - 1) + " ms");
            System.out.println("Insert Combined QuickSort:" + insert.get(count - 1) + " ms");
            System.out.println("Stack Based QuickSort:" + stack.get(count - 1) + " ms\n");
            System.out.println("Pivot and Insert QuickSort:" + pi_in.get(count - 1) + " ms");
            System.out.println("Pivot and Stack QuickSort:" + pi_sta.get(count - 1) + " ms");
            System.out.println("Stack and Insert QuickSort:" + in_sta.get(count - 1) + " ms\n");
            System.out.println("Three Method QuickSort:" + pi_in_sta.get(count - 1) + " ms\n");
        }
        // use iterator to finish traversal
        System.out.println("\n" + times + " 次排序，八种快排方法的每次排序平均用时如下：");
        // get the entry iterator
        Iterator<Map.Entry<String, ArrayList<Long>>> entryIterator = container.entrySet().iterator();
        while (entryIterator.hasNext()) {
            // store current entry
            Map.Entry<String, ArrayList<Long>> entry = entryIterator.next();
            // get the description
            String desIterator = entry.getKey();
            // get the value iterator
            Iterator<Long> timeIterator = entry.getValue().iterator();
            while (timeIterator.hasNext()) {
                totalTime += timeIterator.next();
            }
            System.out.println(desIterator + (totalTime/times) + " ms");
            totalTime = 0;
        }
    }
}
