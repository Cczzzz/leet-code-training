import java.util.Arrays;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class LeetCode20191019 {
    public static void main(String[] args) {
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        main0(input);
    }

    public static void main0(int[] input) {
        /**
         * 温度在30-70
         * 温度值做下标，温度的下标做值。数字默认值是0会和下标为0时混淆，所以+1
         * 每个温度对比它温度小的temp里面比较，如果有值计算下标的差为天数
         */
        int[] temp = new int[100 - 30];
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int c = input[i];
            for (int j = 0; j < c - 30; j++) {
                if (temp[j] > 0) {
                    result[temp[j] - 1] = i - (temp[j] - 1);
                    temp[j] = 0;
                }
            }
            temp[c - 30] = i + 1;
        }
        System.out.println(Arrays.toString(result));
    }
}
