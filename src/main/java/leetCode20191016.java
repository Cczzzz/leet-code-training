/**
 * @author chenchang
 * @date 2019/10/16 22:47
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""4
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class leetCode20191016 {
    public static void main(String[] args) {
        String[] strings = new String[]{"afaffloweraaaa", "vvflowaaaa", "11111flightaaaa"};
        System.out.println(contains("afafflower", "vv"));
        System.out.println(main0(strings));
    }

    public static String main0(String[] strings) {
        int minIndex = 0;
        String min = strings[minIndex];
        //取最小字符串，匹配的值一定在最小字符串中
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < min.length()) {
                min = strings[i];
                minIndex = i;
            }
        }
        int start = 0;
        int end = 1;
        String matchStr = "";
        while (end <= min.length()) {
            /**循环
             * 如果匹配到end就向后延申一位
             * 记录最长
             * 如果匹配不到说明当前end肯定不在其他字符串中
             * 从end位重新开始
             *
             */
            String mark = min.substring(start, end);
            if (match(strings, mark, minIndex)) {
                if ((end - start) > matchStr.length()) {
                    matchStr = mark;
                }
                end++;
            } else {
                end++;
                start = end -1;
            }
        }
        return matchStr;
    }

    public static boolean match(String[] strings, String mark, int minIndex) {
        for (int i = 0; i < strings.length; i++) {
            if (i == minIndex) {
                continue;
            }
            if (!contains(strings[i], mark)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(String a, String b) {
        char[] charsB = b.toCharArray();
        char[] charsA = a.toCharArray();
        for (int i = 0; i < charsB.length; i++) {
            for (int j = 0; j < charsA.length; j++) {
                if (charsA[j] == charsB[i]) {
                    if (++i == charsB.length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
