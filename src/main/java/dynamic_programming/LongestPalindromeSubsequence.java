package dynamic_programming;

public class LongestPalindromeSubsequence {
    /*
    string: a b k c c b c
     */
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence(0, "abbaasdasdffaaaff".length() - 1, "abbaasdasdffaaaff"));
        System.out.println(longestPalindromeDP("abbaasdasdffaaaff"));
    }
/*
problem string - find the longest possible palindrome sequence in the given string - return length of the palindrome
a b k c c b c - 4
0 len(a) - 1 seq


 */
    static int longestPalindromeSubsequence(int start, int end, String seq) {
        if(start > end) {
            return 0;
        }
        if(start == end) {
            return 1;
        }
        if(seq.charAt(start) ==  seq.charAt(end)) {
            return 2+longestPalindromeSubsequence(start +1, end - 1, seq);
        } else {
         return Math.max(
                 longestPalindromeSubsequence(start+1, end, seq),
                 longestPalindromeSubsequence(start, end -1, seq)
         );
        }
    }


    static int longestPalindromeDP(String seq) {
        int dp[][]= new int[seq.length()][seq.length()];
        for(int i = 0; i< seq.length(); i++) {
            for(int j = 0; j< seq.length(); j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }
                if(i > j) {
                    dp[i][j] = 0;
                }

            }
        }
        int i = 0,j =1, temp = 1;

        while(true) {
            if(j == seq.length()) {
                i = 0;
                j = ++temp;
                if(temp == seq.length() ) {
                    break;
                }
            }
            if(seq.charAt(i) == seq.charAt(j)) {
                dp[i][j] = 2 + dp[i+1][j-1];
            } else {
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
            i++;
            j++;
        }

//        0, 1 -> 1, 2 -> 2, 3 -> 3, 4
//        0, 2 -> 1, 3 -> 2, 4,
//        for(int i = 0; i< j; i++) {
//            temp++;
//            for(int j = i + temp; j < seq.length(); j++) {
//
//            }
//        }
        return dp[0][seq.length() - 1];
    }
}
