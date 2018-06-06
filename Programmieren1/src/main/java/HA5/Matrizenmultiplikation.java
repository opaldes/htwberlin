package HA5;

import java.util.Arrays;

public class Matrizenmultiplikation {

    // prüft ob ein mehrdimensionales Integer-Array eine valide Matrix ist
    static boolean isMatrix(int[][] multiDimArray) {
        int rows = multiDimArray.length;
        int cols = multiDimArray[0].length;
        boolean result = true;

        for (int i = 1; i < rows; i++) {
            if (multiDimArray[i].length != cols) {
                result = false;
                break;
            }
        }

        return result;
    }


    // Prüft ob die Argumente valide Matritzen sind und führt eine Matrizenmultiplikation aus
    static int[][] mult(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[0][0];

        if (isMatrix(matrix1) && isMatrix(matrix2)) {
            /*
             * sei "c1" die Anzahl der Spalten von Matrix1 und "r2" die Anzahl der Zeilen von Matrix2, so gilt:
             * Matrizenmultiplikation durchführbar wenn: c1 = r2
             */
            int r1  = matrix1.length;
            int c1  = matrix1[0].length;
            int r2  = matrix2.length;
            int c2  = matrix2[0].length;

            if (c1 == r2) {
                // Ergebnismatrix ergibt sich aus r1 * c2
                result = new int[r1][c2];

                // Standardalgorithmus von https://de.wikipedia.org/wiki/Matrizenmultiplikation
                // Schleife über die Zeilen von C (result)
                for (int i = 0; i < r1; i++) {
                    // Schleife über die Spalten von C (result)
                    for (int k = 0; k < c2; k++) {
                        // Schleife über die Spalten von A (matrix1) / Zeilen von B (matrix2)
                        for (int j = 0; j < c1; j++) {
                            // Bildung der Produktsumme
                            result[i][k] = result[i][k] + (matrix1[i][j] * matrix2[j][k]);
                        }
                    }
                }

            } else {
                System.out.println("matrix1 muss ebenso viele Spalten wie die matrix2 Zeilen haben, damit die Matrizenmultiplikation durchführbar ist");
            }
        } else {
            System.out.println("matrix1 & matrix2 müssen jeweils eine konstante Anzahl an Zeilen und Spalten aufweisen");
        }

        return result;
    }

    public static void printMult (int[][] ergebnis) {
        for (int i = 0; i < ergebnis.length; i++) {
            System.out.println(Arrays.toString(ergebnis[i]));
        }
    }

    public static void main(String[] args) {
        // Normalfall
        System.out.println("*** Normalfall ***");
        int[][] m1 = new int[][]
                {
                        {1, 2, 3},
                        {2, 2, 3},
                        {3, 2, 3}
                };
        int[][] m2 = new int[][]
                {
                        {1, 2},
                        {2, 2},
                        {3, 2}
                };
        printMult(mult(m1, m2));

        // invalide Matrix
        System.out.println("\n*** invalide Matrix ***");
        m1 = new int[][]
                {
                        {1, 2},
                        {2}
                };
        m2 = new int[][]
                {
                        {1},
                        {2}
                };
        printMult(mult(m1, m2));

        // invalide Matritzen
        System.out.println("\n*** invalide Matritzen ***");
        m1 = new int[][]
                {
                        {1, 2},
                        {2, 2}
                };
        m2 = new int[][]
                {
                        {1, 2}
                };
        printMult(mult(m1, m2));

        // Zeilenvektor mal Spaltenvektor
        System.out.println("\n*** Zeilenvektor mal Spaltenvektor ***");
        m1 = new int[][]
                {
                        {1, 2, 3, 4}
                };
        m2 = new int[][]
                {
                        {1},
                        {2},
                        {3},
                        {4}
                };
        printMult(mult(m1, m2));

        // Spaltenvektor mal Zeilenvektor
        System.out.println("\n*** Spaltenvektor mal Zeilenvektor ***");
        m1 = new int[][]
                {
                        {1},
                        {2},
                        {3},
                        {4},
                        {5}
                };
        m2 = new int[][]
                {
                        {1, 2, 3, 4}
                };
        printMult(mult(m1, m2));

        // Matrix mal Vektor
        System.out.println("\n*** Matrix mal Vektor ***");
        m1 = new int[][]
                {
                        {1, 2, 3},
                        {2, 2, 3},
                        {3, 2, 3},
                        {4, 2, 3},
                        {5, 2, 3}
                };
        m2 = new int[][]
                {
                        {1},
                        {2},
                        {3}
                };
        printMult(mult(m1, m2));

        // Vektor mal Matrix
        System.out.println("\n*** Vektor mal Matrix ***");
        m1 = new int[][]
                {
                        {1, 2, 3, 4}
                };
        m2 = new int[][]
                {
                        {1, 2, 3},
                        {2, 2, 3},
                        {3, 2, 3},
                        {4, 2, 3}
                };
        printMult(mult(m1, m2));

        // Quadrat einer Matrix
        System.out.println("\n*** Quadrat einer Matrix ***");
        m1 = new int[][]
                {
                        {1, 2},
                        {1, 2}
                };
        m2 = m1;
        printMult(mult(m1, m2));
    }
}
