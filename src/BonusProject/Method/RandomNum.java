package BonusProject.Method;

import java.util.Random;

public class RandomNum {
    // define a seed
    private static long seed;
    // define a upper and lower bound
    private static long upperBound = 5705131461154942755L;
    private static long lowerBonud = 44930055032L;
    // define some numbers to finish changing seed
    private static long random_1 = 19031;
    private static long random_2 = 463;
    private static long random_3 = 363756786235277L;

    // intialize the seed
    public RandomNum () {
        seed = System.currentTimeMillis();
    }

    /**
     *  make the seed random
     * @param seed  original seed
     * @return      seed has been changed
     */
    public static long changeSeed(long seed) {
        if (seed < lowerBonud)
            return (seed * random_1 + random_2);
        else if (seed >= lowerBonud && seed <= upperBound)
            return (seed * random_2);
        else
            return (seed % random_3);
    }

    /**
     *  get the random
     * @return random number which is producted by the random seed
     */
    public int getRandomNum() {
        Random random = new Random(seed);
        seed = changeSeed(seed);
        return random.nextInt();
    }

    // get the absolute value
    /*private static int getAbsolute(int value) {
        if (value > 0)
            return value;
        else return (-value);
    }*/
}
