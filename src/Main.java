import Bank.*;

public class Main {
    public static void main(String[] args) {
        // Erstellung von Payment-Objekten unter Verwendung verschiedener Konstruktoren
        Payment payment1 = new Payment("2023-10-29", 100.0, "Eingehende Zahlung", 0.02, 0.01);
        Payment payment2 = new Payment(payment1); // Kopierkonstruktor
        Payment payment3 = new Payment("2023-10-29", -50.0, "Ausgehende Zahlung", 0.02, 0.01);

        // Erstellung von Transfer-Objekten unter Verwendung verschiedener Konstruktoren
        Transfer transfer1 = new Transfer("2023-10-29", 500.0, "Geldüberweisung", "Hase", "Erklärbär");
        Transfer transfer2 = new Transfer(transfer1); // Kopierkonstruktor
        Transfer transfer3 = new Transfer("2023-10-29", -200.0, "Negative Überweisung", "Hase2", "Erklärbär2");

        // Testen der calculate() Methode
        System.out.println("Berechnungen:");
        System.out.println("Berechneter Betrag für Payment 1: " + payment1.calculate());
        System.out.println("Berechneter Betrag für Payment 2: " + payment2.calculate());
        System.out.println("Berechneter Betrag für Payment 3: " + payment3.calculate());
        System.out.println("Berechneter Betrag für Transfer 1: " + transfer1.calculate());
        System.out.println("Berechneter Betrag für Transfer 2: " + transfer2.calculate());
        System.out.println("Berechneter Betrag für Transfer 3: " + transfer3.calculate());

        // Testen der equals() Methode
        System.out.println("\nGleichheitsprüfungen:");
        System.out.println("Payment 1 ist gleich Payment 2: " + payment1.equals(payment2));
        System.out.println("Payment 1 ist gleich Payment 3: " + payment1.equals(payment3));
        System.out.println("Transfer 1 ist gleich Transfer 2: " + transfer1.equals(transfer2));
        System.out.println("Transfer 1 ist gleich Transfer 3: " + transfer1.equals(transfer3));

        // Testen der toString() Methode
        System.out.println("\nZeichenkettenrepräsentationen:");
        System.out.println("Test Payment 1:\n" + payment1.toString() + "\n");
        System.out.println("Test Transfer 1:\n" + transfer1.toString());
    }
}