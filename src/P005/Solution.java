package P005;

public class Solution {
    /*
    思路：动态规划
    1. 字符串长度为0或者1时，此时最长回文串就为本身
    2. 如果字符串长度大于1时，此时递归，设a[i][i]用来存储从i到j是否为回文串
    遍历从2开始到字符串长度结束，开始遍历是否为回文串
     */
    public String longestPalindrome(String s) {
        int L=s.length();
        //如果字符串长度小于2，即为""或者如"a"此类，那么即为回文串，则返回本身
        if (L<2){
            return s;
        }
        char str[] = s.toCharArray();
        //初始化记录数组
        boolean ck[][]=new boolean[L][L];
        //记录最大值
        int max=1;
        //保存最长数据
        String tmp =""+s.charAt(0);
        //本身到本身肯定是回文串
        for (int i = 0; i < L; i++) {
            ck[i][i]=true;
        }

        for (int i = 2; i <= L ; i++) {
            for (int j = 0; j < L-i+1; j++) {
                if (str[j]==str[j+i-1]){
                    if (i<3){
                        ck[j][j+i-1]=true;
                    }else{
                        ck[j][j+i-1]=ck[j+1][j+i-2];

                    }
                    if (ck[j][j+i-1]&&i>max){
                        tmp=s.substring(j,j+i);
                    }
                }else {
                    ck[j][j+i-1]=false;
                }
            }
        }

        return tmp;
    }

    /*
    官方解法
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


//    public String longestPalindrome3(String s) {
//        int len=s.length();
//        String res;
//        if (len<2){
//            return s;
//        }
//        //记录回文串最大长度
//        int max=0;
//        char []str=s.toCharArray();
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len&&i-j>=0&&i+j<len; j++) {
//                if (str[i+j]==str[i-j]){
//                    max++;
//                }
//            }
//        }
//
//
//
//        return res;
//    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        String a="ac";
        System.out.println(solution.longestPalindrome(a));
    }
}
