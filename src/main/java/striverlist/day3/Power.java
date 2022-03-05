package striverlist.day3;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2,2));

    }

    public static double power(double x, double n) {
        double ans = 1.0;
        double pow = n;
        if( n < 0) {
            pow = pow* -1;
        }
        while(pow > 0) {
            if(pow%2 == 1) {
                ans *= x;
                pow--;
            } else {
                x = x * x;
                pow = pow/2;
            }
        }
        if(n < 0) return (double)1.0/(double)ans;
        return ans;
    }
}

