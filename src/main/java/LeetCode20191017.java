import java.util.ArrayList;
import java.util.List;

/***
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 */
public class LeetCode20191017 {

    public static void main(String[] args) {
        int[] gas = new int[]{1, 5, 8, 7, 9, 4, 1, 9};
        int[] cost = new int[]{5, 1, 9, 7, 1, 7, 3, 5};
        int i = main0(gas, cost);
        System.out.println(i);
        if (i != -1) {
            System.out.println(verify(i, gas, cost));
        }
    }

    public static int main0(int[] gas, int[] cost) {
        int start = 0;
        int yield = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total +=  gas[i] - cost[i];
            yield +=  gas[i] - cost[i];
            if (yield < 0) {
                start = i + 1;
                yield = 0;
            }
        }
        return total > 0 ? start : -1;
    }

    public static boolean verify(int start, int[] gas, int[] cost) {
        int total = 0;
        for (int i = start; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        for (int i = 0; i < start; i++) {
            total += gas[i] - cost[i];
        }
        return total >= 0;
    }

}
