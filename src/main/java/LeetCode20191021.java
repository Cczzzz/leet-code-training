import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 */
public class LeetCode20191021 {
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 3, 2, 2,};
        int k = 2;
        System.out.println(Arrays.toString(main0(input, k)));

        int[] input1 = new int[]{1, 1, 2, 2, 3, 4, 5, 6, 4, 5, 6, 4, 5, 6};
        int k1 = 4;
        System.out.println(Arrays.toString(main0(input1, k1)));
    }

    public static int[] main0(int[] input, int k) {
        int[] result = new int[k];
        Link head = new Link();
        head.n = 1;
        head.v = input[0];
        for (int i = 1; i < input.length; i++) {
            Link temp = head.put(head, input[i]);
            if (temp != null) {
                head = temp;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = head.v;
            head = head.next;
        }
        return result;
    }

    //链表实现优先级队列
    static class Link {
        Link next;
        int v;
        int n;

        public Link put(Link temp, int i) {
            if (i == temp.v) {
                temp.n++;
                return temp;
            }
            if (temp.next == null) {//如果没找到追加到尾部无事发生
                Link append = new Link();
                append.n = 1;
                append.v = i;
                temp.next = append;
            } else {
                Link next = put(temp.next, i);
                if (next != null) {//如果下层返回了元素，比较n
                    if (next.n > temp.n) {//比当前大位置前移
                        temp.next = next.next;
                        next.next = temp;
                        return next;
                    } else {//没当前大挂到当前尾部
                        temp.next = next;
                    }
                }
            }
            return null;
        }


    }

}