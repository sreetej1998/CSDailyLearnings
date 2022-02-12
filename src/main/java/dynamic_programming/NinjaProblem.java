package dynamic_programming;

/*
Input: ArrayList<ArrayList<Integers>>
output: Maximum merit points the ninja can do over the 3 activities.
constraint: cannot perform consecutive same actions.
 */
public class NinjaProblem {
    public static void main(String[] args) {
       int actions[][] =  { {1,2,5}, {3,1,1}, {3,3,3}};
        System.out.println(maxMeritPoints(actions, -1, 0));
    }

    static int maxMeritPoints( int actions[][], int currAction, int day) {
        int a[] = new int[3];
        if(day >= actions.length) return 0;
        for(int i = 0; i <3; i++) {
            if(i!=currAction) {
                a[i] = actions[day][i] + maxMeritPoints(actions, i, day+1);
            }
        }
        return Math.max(Math.max(a[0], a[1]), a[2]);
    }

//    TODO
    static int bottomUpMeritPoints(int actions[][]) {
        return -1;
    }
}
