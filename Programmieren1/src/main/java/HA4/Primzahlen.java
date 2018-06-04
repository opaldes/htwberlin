package HA4;

import java.util.Arrays;

public class Primzahlen {

    // prüft ob eine Zahl ganzzahliger Teiler einer anderen Zahl ist
    static boolean istTeiler(int dividend, int divisor) {
        return dividend % divisor == 0; // Modulo (%) berechnet den Rest einer Division
    }

    // prüft ob eine Zahl eine Primzahl ist
    static boolean istPrimzahl(int zahl) {
        boolean ergebnis = false;

        if (zahl == 2) ergebnis = true; // 2 ist die einzige gerade Primzahl
        if (zahl > 2 && (zahl % 2 != 0)) { // prüfe nur ungerade Zahlen größer als 2
            boolean teilerGefunden = false;

            for (int divisor = 2; divisor < zahl; divisor++) {
                teilerGefunden = istTeiler(zahl, divisor);
                if (teilerGefunden) break; // weitere Iterationen sinnlos, da bereits keine Primzahl mehr
            }

            if (!teilerGefunden) ergebnis = true;
        }
        return ergebnis;
    }

    public static void main(String[] args) {

        int zahl = 0;
        int index = 0;
        int[] primzahlen = new int[100];

        while (primzahlen[99] == 0) {
            if (istPrimzahl(zahl)) {
                primzahlen[index] = zahl;
                index++;
            }
            zahl++;
        }

        // http://primes.utm.edu/lists/small/1000.txt
        System.out.println(Arrays.toString(primzahlen));
    }
}
