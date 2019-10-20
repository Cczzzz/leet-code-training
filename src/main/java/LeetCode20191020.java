import java.util.Arrays;

/***
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

public class LeetCode20191020 {
    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        main0(input);
    }

    public static void main0(int[] input) {
        int[] tem = new int[input.length];
        for (int i : input) {
            if (tem[i - 1] == 0) {
                tem[i - 1] += 1;
            }
        }

        for (int i = 0; i < tem.length; i++) {
            if (tem[i] == 0) {
                System.out.print(i+1+" ");
            }
        }
        System.out.println();
    }
}
