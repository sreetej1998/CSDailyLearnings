package dynamic_programming;

public class LongestCommonSubstring {

/*
1 - 0 1 1
2 - 1 2 - 1, 2 3 - 1,
 */
    public static void main(String[] args) {
        System.out.println(lcs("dmadam", "madam", 0, 0));
    }
//
    static int longestCommonSubstring( String seq, String seq1, int i, int j) {
        int count = 0;
        if(i >= seq.length() || j >= seq1.length()) {
            return 0;
        }
        if(seq.charAt(i) == seq1.charAt(j)) {
            count  = 1+ longestCommonSubstring(seq, seq1, i + 1, j + 1);
        }
        return Math.max(count, Math.max(
                longestCommonSubstring(seq, seq1, i, j+1),
                longestCommonSubstring(seq, seq1, i+1, j)
        ));
    }


    static String lcs(String a, String b, int i, int j) {
        String eq = "";
        if(i>=a.length() || j>=b.length()) {
            return "";
        }
        if(a.charAt(i) == b.charAt(j)) {
            eq = a.charAt(i) + lcs(a, b, i+1, j+1);
        }
        String p = lcs(a, b, i+1, j);
        String q = lcs(a, b, i, j+1);
        if(p.length() > q.length()) {
            if(p.length() > eq.length()) {
                return p;
            } else {
                return eq;
            }
        } else {
            if(q.length() > eq.length()) {
                return q;
            } else {
                return eq;
            }
        }

    }
}
