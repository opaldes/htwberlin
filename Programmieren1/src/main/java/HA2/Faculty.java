package HA2;

public class Faculty {
    public static long getFaculty() {
        byte n = 4;
        long result = 1;

        if (n < 0 || n > 20) {
            throw new Error("n is too big or less than zero - cannot calculate Faculty");
        } else {
            for (byte i = 1; i <= n; i++) {
                result *= i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getFaculty());
    }
}
