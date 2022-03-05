package striverlist.day2;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverLappingSubIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = merge(intervals);
        for(int i = 0; i < mergedIntervals.length; i++) {
            for(int j = 0; j < mergedIntervals[0].length; j++) {
                System.out.print(mergedIntervals[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] merge(int[][] list) {
        ArrayList<int[]> sol = new ArrayList<>();
        Arrays.sort(list, (a, b) -> a[0] - b[0]);
        if( list.length < 1) {
            return sol.toArray(new int[0][]);
        }
        sol.add(list[0]);
        for(int  i = 1; i < list.length; i++ ) {
            int size = sol.size() - 1;
            if(list[i][0] <= sol.get(size)[1]) {
                sol.get(size)[1] = Math.max(list[i][1], sol.get(size)[1]);
            } else {
                sol.add(list[i]);
            }
        }
        return sol.toArray(new int[0][]);
    }
}
