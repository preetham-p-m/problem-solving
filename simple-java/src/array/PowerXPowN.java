package array;

public class PowerXPowN {

    public static void main(String[] args) {
        System.out.println(start(2, 10));
    }

    public static double start(double x, int n) {
        double ans = 1;
        int nn = n;

        boolean negative = false;

        if (nn < 0) {
            nn = nn * (-1);
            negative = true;
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                x *= x;
                nn /= 2;

            }
        }

        if (negative) {
            return 1 / (ans);
        }

        return ans;
    }
}
