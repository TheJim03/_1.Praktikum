import Bank.Payment;
import Bank.Transfer;

public class Main {
    public static void main(String[] args) {

        Payment payment1 = new Payment("01.01.2023", 100.0, "Einzahlung");
        Payment payment2 = new Payment("02.01.2023", 50.0, "Auszahlung", 0.01, 0.02);
        Payment payment3 = new Payment(payment2); // Copy-Konstruktor

        Transfer transfer1 = new Transfer("03.01.2023", 200.0, "Überweisung", "Sender1", "Recipient1");
        Transfer transfer2 = new Transfer(transfer1); // Copy-Konstruktor

        // Ausgabe der Klassenattribute
        System.out.println("Payment 1:");
        payment1.printObject();

        System.out.println("\nPayment 2:");
        payment2.printObject();

        System.out.println("\nPayment 3 (Copy of Payment 2):");
        payment3.printObject();

        System.out.println("\nTransfer 1:");
        transfer1.printObject();

        System.out.println("\nTransfer 2 (Copy of Transfer 1):");
        transfer2.printObject();
    }
}