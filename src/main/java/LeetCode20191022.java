/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 * <p>
 * <p>
 * Example 5:
 * <p>
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class LeetCode20191022 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
//        String s = "aab";
//        String p = "c*a*b*b";
        // String s = "aab";
        //String p = "c*a*b";
//        String s = "mississippi";
//        String p = "mis*is*p*.";
        System.out.print(main1(s, p));

    }

    /**
     * 因为*可以表示它的前一个元素，所以倒序更方便
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean main1(String s, String p) {
        char[] pchars = p.toCharArray();
        char[] schars = s.toCharArray();
        int j = schars.length - 1;
        for (int i = pchars.length - 1; i >= 0; ) {
            if (j < 0) {
                if (i == 1 && pchars[i] == '*') {
                    return true;
                }
                return false;
            }
            char pstr = pchars[i];
            char sstr = schars[j];
            if (pstr != sstr) {
                if (pstr != '.') {
                    if (pstr == '*') {
                        if (pchars[i - 1] != sstr) {
                            if (pchars[i - 1] != '.') {
                                j++;
                                i--;
                            }
                        } else {
                            i++;
                        }
                    } else {
                        return false;
                    }
                } else {
                    pchars[i] = sstr;
                }
            }
            i--;
            j--;
        }
        if (j >= 0) {
            return false;
        }
        return true;
    }

    /**
     * 无法 识别  String s = "aab";
     * String p = "c*a*b*b";
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean main0(String s, String p) {
        char[] pchars = p.toCharArray();
        char[] schars = s.toCharArray();
        int j = 0;
        char last = '?';
        for (int i = 0; i < pchars.length; ) {
            if (j >= schars.length) {
                return false;
            }
            char pstr = pchars[i];
            char sstr = schars[j];


            while (true) {
                if (pstr != sstr) {
                    //如果为. 那他就是要匹配的元素
                    if (pstr == '.') {
                        pstr = sstr;
                        break;
                    }
                    //如果
                    if (pstr == '*') {
                        pstr = last;
                        //如果为*值为上一个 如果上一个匹配 s 让过 p不变。如果不匹配让过p，s不变
                        if (last == sstr) {
                            i--;
                        } else {
                            j--;
                        }
                        break;
                    } else {
                        if (i == pchars.length - 1) {
                            return false;
                        }
                        //如果没匹配，下一个为* 让过当前和下一个。s不变
                        if (pchars[i + 1] == '*') {
                            i++;
                            j--;
                            break;
                        }
                    }
                    return false;
                } else {
                    break;
                }
            }
            last = pstr;
            i++;
            j++;
        }
        if (j >= schars.length) {
            return true;
        } else {
            return false;
        }
    }
}
