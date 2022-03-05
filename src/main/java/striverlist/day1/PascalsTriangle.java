package striverlist.day1;

import java.util.ArrayList;
import java.util.List;

// Given an integer numRows, return the first numRows of Pascal's triangle.
public class PascalsTriangle {
    public static void main(String[] args) {
        pascalTriangle(2);
    }

    public static List<List<Integer>> pascalTriangle(int num) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(num == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>(){
            { add(1);}
        });
        if(num == 1) {
            return triangle;
        }
        triangle.add(new ArrayList<>(){
            { add(1); add(1);}
        });
        if(num == 2) {
            return triangle;
        }
        for(int i = 0; i < num - 2; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = triangle.get(triangle.size() - 1);
            for(int k = 1; k < prevRow.size() ; k++) {
                int ele = prevRow.get(k) + prevRow.get(k-1);
                row.add(ele);
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;

    }
}
