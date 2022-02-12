package dynamic_programming;

public class LongestCommonSubsequence {
    int dp[][] = new int[1001][1001];
    public static void main(String[] args) {
        System.out.println(lcs("asde", "asdffde", 0, 0));
    }

    public static int longestCommonSub(String a, String b, int i, int j) {
        if(i == a.length() || j == b.length()) {
            return 0;
        }
        if(a.charAt(i) == b.charAt(j)) {
            return 1 + longestCommonSub(a, b, i+1, j+1);
        } else {
            return Math.max(longestCommonSub(a, b, i, j+1), longestCommonSub(a, b, i+1, j));
        }
    }

//    returns the lcs
    public static String lcs(String a, String b, int i, int j) {
        if(i>=a.length() || j>=b.length()) {
            return "";
        }
        if(a.charAt(i) == b.charAt(j)) {
            return a.charAt(i) + lcs(a, b, i+1, j+1);
        }
        String q = lcs(a, b, i, j+1);
        String p = lcs(a, b, i+1, j);
        if(p.length() > q.length()) {
            return p;
        } else {
            return q;
        }
    }

    public int longestCommonSubTopDown(String a, String b, int i, int j) {
        if(i == a.length() || j == b.length()) {
            return 0;
        }
        if(a.charAt(i) == b.charAt(j)) {
            if(dp[i][j]!=0) {
                return dp[i][j];
            }
            dp[i][j]= 1 + longestCommonSub(a, b, i+1, j+1);
            return dp[i][j];

        } else {
            if(dp[i][j+1]==0) {
                dp[i][j+1] = longestCommonSub(a, b, i, j+1);
            }
            if(dp[i+1][j] == 0) {
                dp[i+1][j] = longestCommonSub(a, b, i+1, j);
            }
            return Math.max(dp[i][j+1], dp[i+1][j]);
        }
    }
}
