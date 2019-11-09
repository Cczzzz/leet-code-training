public class LeetCode20191109 {

    /**
     * 数组中的每一个元素相当于一个台阶，假使水量足够大，那么台阶上的积水有多少，例如数组[0,1,0,1,2,1,0,1,3,2,1,2,1]的台阶积水量为6
     * @param args
     */
    public static void main(String[] args) {
        //0，1，0，2，1，0，1，3，2，1，2，1
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = 0;
        int leftTall = a[0];//左高点
        int rightTall = -1;//右高点
        int right = -1;//右高点的下标
        for (int i = 1; i < a.length; i++) {
            //如果比左高点高，存不下水，刷新左高点
            if (a[i] > leftTall) {
                leftTall = a[i];
            } else {
                //第一次进入，或者当前i越过右高点，重新寻找右高点
                if (rightTall == -1 || i >= right) {
                    rightTall = -1;
                    right = -1;
                    for (int j = i + 1; j < a.length; j++) {
                        if (a[j] > rightTall) {
                            rightTall = a[j];
                            right = j;
                        }
                    }
                }
                if (Math.min(rightTall, leftTall) > a[i]) {
                    sum += Math.min(rightTall, leftTall) - a[i];
                }
            }
        }
        System.out.println(sum);
    }
}
