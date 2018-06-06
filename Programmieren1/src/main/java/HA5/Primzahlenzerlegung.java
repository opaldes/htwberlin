package HA5;

public class Primzahlenzerlegung {

    /*
     * aus HA4.Primzahlen (import der Klasse sinnvoller aber noch nicht in den Vorlesungen behandelt) ---------------->
     */

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

    // <-------------------------------------------------------------------------------------------------------------

    // erzeugt ein Array mit einer Anzahl n an Primzahlen
    static int[] berechnePrimzahlen(int n) {
        int zahl = 0;
        int index = 0;
        int[] primzahlen = new int[n];

        while (primzahlen[n - 1] == 0) {
            if (istPrimzahl(zahl)) {
                primzahlen[index] = zahl;
                index++;
            }
            zahl++;
        }

        return primzahlen;
    }

    /*
     * Ermittelt den nächsten ganzzahligen Primzahl-Teiler einer Zahl aus einem vorgegebenen Array an Primzahlen und
     * gibt den Index der jeweiligen Primzahl zurück
     * gibt die Funktion -1 zurück wurde keine passende Primzahl gefunden (z.B. weil das Array zu klein war)
     */
    static int ermittleIndexFuerPrimzahlteiler(int zahl, int[] primzahlen) {
        int index = -1;

        for (int i = 0; i < primzahlen.length; i++) {
            if (istTeiler(zahl, primzahlen[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /*
     * Zerlegt eine Zahl in ihre Primzahlfaktoren und gibt ein 2D-Array mit den benutzten Primzahlen und den
     * jeweiligen Exponenten zurück
     */
    static int[][] berechneAllePrimzahlfaktoren(int zahl, int anzahlDerPrimzahlen) {
        int neueZahl = zahl;
        int[] primzahlen = berechnePrimzahlen(anzahlDerPrimzahlen);
        int[] exponenten = new int[anzahlDerPrimzahlen];

        // Elemente von exponenten mit 0 initialisieren (wird in Java eigentlich automatisch gemacht)
        for (int i = 0; i < exponenten.length; i++) {
            exponenten[i] = 0;
        }

        while (neueZahl != 1) {
            int index = ermittleIndexFuerPrimzahlteiler(neueZahl, primzahlen);
            if (index != -1) {
                neueZahl = neueZahl / primzahlen[index];
                exponenten[index]++;
            } else {
                System.out.println("Der Pool von " + Integer.toString(anzahlDerPrimzahlen) + " Primzahlen war zu gering um Teiler für " + Integer.toString(zahl) + " zu ermitteln!");
                neueZahl = 1;
            }
        }

        return new int[][]{primzahlen, exponenten};
    }

    // wie berechneAllePrimzahlfaktoren nur mit Bildschirmausgabe statt Rückgabewert
    static void printBerechneAllePrimzahlfaktoren(int zahl, int anzahlDerPrimzahlen) {
        int[][] ergebnis = berechneAllePrimzahlfaktoren(zahl, anzahlDerPrimzahlen);

        // zur einfacheren Ausgabe wird ein neues 2D-Array erstellt, bei dem das Exponenten-Array kein Element mit 0 hat
        int benoetigteElemente = 0;
        for (int i = 0; i < ergebnis[1].length; i++) {
            if (ergebnis[1][i] != 0) {
                benoetigteElemente++;
            }
        }

        if (benoetigteElemente != 0) {
            int[][] datenFuerAusgabe = new int[2][benoetigteElemente];
            int index = 0;
            for (int i = 0; i < ergebnis[1].length; i++) {
                if (ergebnis[1][i] != 0) {
                    datenFuerAusgabe[0][index] = ergebnis[0][i];
                    datenFuerAusgabe[1][index] = ergebnis[1][i];
                    index++;
                }
            }

            System.out.print(Integer.toString(zahl) + ":");
            for (int i = 0; i < datenFuerAusgabe[0].length; i++) {
                String spacer = i == 0 ? " " : ", ";
                System.out.print(spacer + "e_" + Integer.toString(datenFuerAusgabe[0][i]) + ": " + Integer.toString(datenFuerAusgabe[1][i]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printBerechneAllePrimzahlfaktoren(4, 1000);
        printBerechneAllePrimzahlfaktoren(60, 1000);
        printBerechneAllePrimzahlfaktoren(100, 3);
        printBerechneAllePrimzahlfaktoren(59, 3);
    }
}
