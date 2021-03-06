package HA2;

public class Fibonacci {
    public static long getFibonacci(byte n) throws Exception {
        long result = 0;

        if (n > 0 && n <= 93) {
            long fibp1 = 0;
            long fibp2 = 0;

            for (byte i = 1; i <= n; i++) {
                result = (i == 1) ? fibp1 + 1 : fibp1 + fibp2;
                fibp2 = fibp1;
                fibp1 = result;
            }

        } else {
            throw new Exception("n is too big or less than zero - cannot calculate Fibonacci");
        }

        return result;
    }

    public static void main(String[] args) {
        for (int n = -5; n <= 10; n++){
            try {
                System.out.println(getFibonacci((byte) n));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
