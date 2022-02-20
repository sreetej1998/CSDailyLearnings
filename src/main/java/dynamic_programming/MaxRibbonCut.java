package dynamic_programming;
/*
Given a number array to represent possible ribbon lengths
and a total ribbon length ‘n,’ we need to find the maximum
number of pieces that the ribbon can be cut into.
 */
public class MaxRibbonCut {
    static int dp[][] = new int[1000][1000];
    public static void main(String[] args) {
        for(int i = 0; i< 1000; i++) {
            for(int j = 0; j< 1000; j++) {
                dp[i][j] = -1;
            }
        }
        int[] ribbonLengths = {2,3,5};

        int total = 5;
        System.out.println(maxRibbonPieces(0, total, ribbonLengths));
        System.out.println(maxRibbonPiecesTopDown(0, total, ribbonLengths));
    }

    public static int maxRibbonPieces(int i, int totalLength, int ribbonLengths[]) {
        if(totalLength == 0) {
            return 0;
        }
        if(i == ribbonLengths.length || totalLength < 0) {
            return Integer.MIN_VALUE;
        }
        int inc = maxRibbonPieces(i, totalLength - ribbonLengths[i], ribbonLengths);
        if(inc != Integer.MIN_VALUE) {
            inc+=1;
        }
        int dontInc = maxRibbonPieces(i+1, totalLength, ribbonLengths);
        return Math.max(inc, dontInc);
    }

    public static int maxRibbonPiecesTopDown(int i, int totalLength, int ribbonLengths[]) {
        if(totalLength == 0) {
            return 0;
        }
        if(i == ribbonLengths.length || totalLength < 0) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][totalLength]!=-1) {
            return dp[i][totalLength];
        }
        int inc = maxRibbonPieces(i, totalLength - ribbonLengths[i], ribbonLengths);
        if(inc != Integer.MIN_VALUE) {
            inc+=1;
        }
        dp[i][totalLength - ribbonLengths[i]] = inc;
        int dontInc = maxRibbonPieces(i+1, totalLength, ribbonLengths);
        dp[i+1][totalLength] = dontInc;
        return Math.max(inc, dontInc);
    }

}
