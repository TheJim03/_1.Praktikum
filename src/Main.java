import Bank.*;

public class Main {
    public static void main(String[] args) {

        /**
         * Erzeugen Sie Objekte der Klassen Payment und Transfer und verwenden Sie dabei alle zur Verfügung
         * stehenden Konstruktoren (inkl. Copy-Konstruktor). Erzeugen Sie insb. auch Payment-Objekte für
         * sowohl Ein- als auch Auszahlungen
         */


        Payment payment1 = new Payment("01.01.2021", 100, "Gehalt");
        Payment payment2 = new Payment("02.01.2021", -50, "Miete");
        Payment payment3 = new Payment(payment1);
        Payment payment4 = new Payment("03.01.2021", 100, "Gehalt", 0.1, 0.2);
        Payment payment5 = new Payment("04.01.2021", -50, "Miete", 0.1, 0.2);
        Payment payment6 = new Payment(payment4);
        Transfer transfer1 = new Transfer("05.01.2021", 100, "Gehalt", "Max", "Moritz");
        Transfer transfer2 = new Transfer("06.01.2021", -50, "Miete", "Moritz", "Max");
        Transfer transfer3 = new Transfer(transfer1);
        Transfer transfer4 = new Transfer("07.01.2021", 100, "Gehalt", "Max", "Moritz");
        Transfer transfer5 = new Transfer("08.01.2021", -50, "Miete", "Moritz", "Max");
        Transfer transfer6 = new Transfer(transfer4);

        /**
         * Testen Sie nun mit Hilfe der calculate()-Methode, ob die Berechnungen für Payment- und Transfer-
         * Objekte korrekt funktionieren. Geben Sie hierfür die Werte auf der Konsole aus.
         * Abschließend sollten auch die in Aufgabe 1 implementierten equals- und toString()-Methoden getestet
         * werden
         */

        System.out.println(payment1.calculate());
        System.out.println(payment2.calculate());
        System.out.println(payment3.calculate());
        System.out.println(payment4.calculate());
        System.out.println(payment5.calculate());
        System.out.println(payment6.calculate());
        System.out.println(transfer1.calculate());
        System.out.println(transfer2.calculate());
        System.out.println(transfer3.calculate());
        System.out.println(transfer4.calculate());
        System.out.println(transfer5.calculate());
        System.out.println(transfer6.calculate());

    }
}