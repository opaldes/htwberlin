package HA4;

public class Tilgungsplan {

    static double round2dp (double x) {
        return  Math.round(x * 100.0) / 100.0;
    }

    /*
     * berechnet ein Tilgungsdarlehen (https://de.wikipedia.org/wiki/Tilgungsdarlehen)
     */
    static void calcTilgungsdarlehen(float schuld, float zinssatz, float tilgung) {
        if (schuld % tilgung != 0) {
            System.out.print("Die Schuld (" + schuld + ") muss ein Vielfaches von der Tilgung (" + tilgung + ") sein.");
        } else {
            float zins = (zinssatz / 100) * schuld;
            float annuitaet = zins + tilgung;
            float restschuld = schuld - tilgung;

            if (restschuld == 0) System.out.print("letzte Rate: ");
            System.out.println(schuld + " | " + zins + " | " + tilgung + " | " + annuitaet);
            if (restschuld != 0) calcTilgungsdarlehen(restschuld, zinssatz, tilgung);
        }
    }

    /*
     * berechnet ein Annuitätendarlehen
     */
    static void calcAnnuitaetendarlehen(double schuld, double zinssatz, double laufzeit) {
        double i = zinssatz / 100;
        double q = 1 + i;
        double annuitaetenfaktor = (Math.pow(q, laufzeit) * i) / (Math.pow(q, laufzeit) - 1);
        double annuitaet = schuld * annuitaetenfaktor;

        double zins = i * schuld;
        double tilgung = annuitaet - zins;
        double restschuld = schuld - tilgung;
        restschuld = round2dp(restschuld);

        if (restschuld == 0) System.out.print("letzte Rate: ");
        System.out.println(round2dp(schuld) + " | " + round2dp(zins) + " | " + round2dp(tilgung) + " | " + round2dp(annuitaet));
        if (restschuld != 0) calcAnnuitaetendarlehen(restschuld, zinssatz, laufzeit - 1);
    }

    public static void main(String[] args) {
        System.out.println("Tilgungsdarlehen (Restschuld | Zins | Tilgung | Annuität)");
        calcTilgungsdarlehen(100000, 5, 20000);
        System.out.println("\nAnnuitätendarlehen (Restschuld | Zins | Tilgung | Annuität)");
        calcAnnuitaetendarlehen(100000, 5, 5);
    }
}
