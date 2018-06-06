package HA6;

public class Taschenrechner {
    public static void errMsg() {
        System.err.println("Ungültiger Operator: erstes Argument muss: '+', '-', '*' oder '/' sein");
    }

    public static int addieren(int a, int b) {
        return a + b;
    }

    public static float addieren(float a, float b) {
        return a + b;
    }

    public static int subtrahieren(int a, int b) {
        return a - b;
    }

    public static float subtrahieren(float a, float b) {
        return a - b;
    }

    public static int dividieren(int a, int b) {
        return a / b;
    }

    public static float dividieren(float a, float b) {
        return a / b;
    }

    public static int multiplizieren(int a, int b) {
        return a * b;
    }

    public static float multiplizieren(float a, float b) {
        return a * b;
    }

    public static void main(String[] args) {
        boolean contin = true;
        String operator = args[0];
        String a = args[1];
        String b = args[2];

        if (a.contains(".") || b.contains(".")) {
            try {
                float arg1 = Float.parseFloat(a);
                float arg2 = Float.parseFloat(b);
                float ergebnis = 0;

                switch (operator) {
                    case "+":
                        ergebnis = addieren(arg1, arg2);
                        break;
                    case "-":
                        ergebnis = subtrahieren(arg1, arg2);
                        break;
                    case "/":
                        ergebnis = dividieren(arg1, arg2);
                        break;
                    case "*":
                        ergebnis = multiplizieren(arg1, arg2);
                        break;
                    default:
                        errMsg();
                        contin = false;
                }

                if (contin) {
                    System.out.println(operator + " " + a + " " + b);
                    System.out.println("Ergebnis: " + Float.toString(ergebnis));
                }

            } catch (NumberFormatException e) {
                System.err.println("Es wurde eine ungültige Zahl eingegeben");
            }

        } else {
            try {
                int arg1 = Integer.parseInt(a, 10);
                int arg2 = Integer.parseInt(b, 10);
                int ergebnis = 0;

                switch (operator) {
                    case "+":
                        ergebnis = addieren(arg1, arg2);
                        break;
                    case "-":
                        ergebnis = subtrahieren(arg1, arg2);
                        break;
                    case "/":
                        ergebnis = dividieren(arg1, arg2);
                        break;
                    case "*":
                        ergebnis = multiplizieren(arg1, arg2);
                        break;
                    default:
                        errMsg();
                        contin = false;
                }

                if (contin) {
                    System.out.println(operator + " " + a + " " + b);
                    System.out.println("Ergebnis: " + Integer.toString(ergebnis));
                }

            } catch (NumberFormatException e) {
                System.err.println("Es wurde eine ungültige Zahl eingegeben");

            }
        }
    }
}
