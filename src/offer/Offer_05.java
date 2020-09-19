package offer;

public class Offer_05 {

    //region 剑指 Offer 05. 替换空格

    /*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

             

    示例 1：

    输入：s = "We are happy."
    输出："We%20are%20happy."
             

    限制：

            0 <= s 的长度 <= 10000*/

    //endregion

    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[3 * s.length()];
        int k = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                result[k++] = '%';
                result[k++] = '2';
                result[k++] = '0';
            } else {
                result[k++] = aChar;
            }
        }
        return new String(result, 0, k);
    }

}
