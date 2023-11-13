// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import bank.*;
import bank.exceptions.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testPrakt3();
    }

    static public void testPrakt1() {
        Transfer transfer = new Transfer("Heute", 50.00, "Essen", "Till", "Janobert");
        transfer.toString();//Ausgabe

        Payment payment = new Payment("Heute", 50.00, "Vorgestreckt", 0.01, 0.01);
        payment.toString();//Ausgabe

        Transfer copied = new Transfer(transfer); //Copy Konstruktor von Transfer
        copied.toString(); //Ausgabe

        Payment copiedPayment = new Payment(payment); //Copy Konstruktor von Payment
        copiedPayment.toString();//Ausgabe

        Payment notRight = new Payment("16.10.2023", 100, "Essen", -0.1, 1.5);

    }

    public static void testPrakt2() {
        //Beispiel 1 Calculate
        System.out.println("Beispiel 1 Calculate");
        Payment payment = new Payment("Heute", 1000.00, "swag", 0.05, 0.1);
        System.out.println(payment.calculate());

        //Beispiel 2 Calculate
        System.out.println("Beispiel 2 Calculate");
        Payment payment2 = new Payment("Heute", -1000.00, "swag", 0.05, 0.1);
        System.out.println(payment2.calculate());

        //Transfer Calculate
        System.out.println("Transfer Calculate");
        Transfer transfer = new Transfer("Heute", 1000.00, "swag", "Till", "Janobert");
        System.out.println(transfer.calculate());


        //Transfer equals
        System.out.println("Transfer equals");
        Transfer transferEquals = new Transfer("Heute", 1000.00, "swag", "Till", "Janobert");
        System.out.println("Sollte true sein: " + transfer.equals(transferEquals));
        Transfer transferNotEquals = new Transfer("Heute", 1001.00, "swag", "Till", "Janobert");
        System.out.println("Sollte false sein: " + transfer.equals(transferNotEquals));

        //Payment equals
        System.out.println("Payment equals");
        Payment paymentEquals = new Payment("Heute", 1000.00, "swag", 0.05, 0.1);
        System.out.println("Sollte true sein: " + payment.equals(paymentEquals));
        Payment paymentNotEquals = new Payment("Heute", 1000.00, "swag", 0.05, 0.2);
        System.out.println("Sollte false sein: " + payment.equals(paymentNotEquals));

        //Copy Konstruktor equals Payment
        System.out.println("Copy Konstruktor equals Payment");
        Payment paymentCopy = new Payment(payment);
        System.out.println("Sollte true sein: " + payment.equals(paymentCopy));
        Payment paymentCopyNotEquals = new Payment(payment2);
        System.out.println("Sollte false sein: " + payment.equals(paymentCopyNotEquals));

        //Copy Konstruktor equals Transfer
        System.out.println("Copy Konstruktor equals Transfer");
        Transfer transferCopy = new Transfer(transfer);
        System.out.println("Sollte true sein: " + transfer.equals(transferCopy));
        Transfer transferCopyNotEquals = new Transfer(transferNotEquals);
        System.out.println("Sollte false sein: " + transfer.equals(transferCopyNotEquals));

        //Payment toString
        System.out.println("Payment toString");
        System.out.println(payment.toString());

        //Transfer toString
        System.out.println("Transfer toString");
        System.out.println(transfer.toString());

        //Payment setAmount
        System.out.println("Payment setAmount");
        System.out.println("Vorher: " + payment.toString());
        payment.setAmount(2000.00);
        System.out.println("Nachher: " + payment.toString());

        //Transfer setAmount
        System.out.println("Transfer setAmount");
        System.out.println("Vorher: " + transfer.toString());
        transfer.setAmount(2000.00);
        System.out.println("Nachher: " + transfer.toString());
    }

    static public void testPrakt3() {
        //Teste Private Bank
        System.out.println("Teste Private Bank");
        PrivateBank privateBank = new PrivateBank("Sparkasse", 0.05, 0.1);
        privateBank.print();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Payment("Heute", 1000.00, "swag", 0.05, 0.1));
        transactions.add(new Transfer("Heute", 1000.00, "swag", "Till", "Janobert"));
        transactions.add(new Transfer("Heute", 3000.00, "swag", "Janobert", "Till"));

        //createAccount
        try {
            privateBank.createAccount("Till");

            privateBank.createAccount("Janobert", transactions);

        } catch (AccountAlreadyExistsException | TransactionAlreadyExistException | TransactionAttributeException e) {
            System.out.println(e.getMessage());
        }

        try {
            privateBank.createAccount("Till");
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        privateBank.print();
        System.out.println(privateBank.getAccountBalance("Janobert"));

        //addTransaction
        System.out.println("addTransaction");
        try {
            privateBank.addTransaction("Till", new Payment("01.01.1999", 3000.00, "Einzahlung", 0.05, 0.1));
            privateBank.addTransaction("Till", new Transfer("02.05.2003", 2.00, "swag", "Till", "Simon"));
        } catch (TransactionAlreadyExistException | AccountDoesNotExistException | TransactionAttributeException e) {
            System.out.println(e.getMessage());
        }
        privateBank.print();

        //removeTransaction
        System.out.println("removeTransaction");
        try {
            privateBank.removeTransaction("Till", new Payment("01.01.1999", 3000.00, "Einzahlung", 0.05, 0.1));
            privateBank.removeTransaction("Till", new Payment("01.01.1999", 3000.00, "Einzahlung", 0.05, 0.1));
        } catch (AccountDoesNotExistException | TransactionDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
        privateBank.print();

        //containsTransaction
        System.out.println("containsTransaction");
        System.out.println(privateBank.containsTransaction("Janobert", new Payment("Heute", 1000.00, "swag", 0.05, 0.1)));
        System.out.println(privateBank.containsTransaction("Janobert", new Payment("Heute", 1000.00, "swag", 0.05, 0.2)));

        //Teste Private Bank Alt
        System.out.println("Teste Private Bank Alt");
        PrivateBankAlt privateBankAlt = new PrivateBankAlt("Sparkasse", 0.05, 0.1);
        try{
            privateBankAlt.createAccount("Till");
            privateBankAlt.createAccount("Janobert", transactions);
        }catch (AccountAlreadyExistsException | TransactionAlreadyExistException | TransactionAttributeException e){
            System.out.println(e.getMessage());
        }
        System.out.println(privateBankAlt.getAccountBalance("Janobert"));

        //Teste Incoming/Outgoing Transfer
        System.out.println("Teste Incoming/Outgoing Transfer");
        IncomingTransfer incomingTransfer = new IncomingTransfer(new Transfer("Heute", 1000.00, "swag", "Till", "Janobert"));
        System.out.println(incomingTransfer.calculate());
        OutgoingTransfer outgoingTransfer = new OutgoingTransfer(new Transfer("Heute", 1000.00, "swag", "Till", "Janobert"));
        System.out.println(outgoingTransfer.calculate());
        try {
            privateBank.addTransaction("Till", incomingTransfer);
            privateBank.addTransaction("Till", outgoingTransfer);
        } catch (TransactionAlreadyExistException | AccountDoesNotExistException | TransactionAttributeException e) {
            System.out.println(e.getMessage());
        }
        privateBank.print();
        System.out.println(privateBank.getAccountBalance("Till"));

        //test getTransactions
        System.out.println("Teste getTransactions");
        System.out.println(privateBank.getTransactions("Till"));
        System.out.println(privateBank.getTransactions("Janobert"));

        //test getTransactionsByType
        System.out.println("Teste getTransactionsByType");
        System.out.println(privateBank.getTransactionsByType("Till", true));
        System.out.println(privateBank.getTransactionsByType("Till", false));

        //test getTransactionsSorted
        System.out.println("Teste getTransactionsSorted");
        System.out.println(privateBank.getTransactionsSorted("Till", true));
        System.out.println(privateBank.getTransactionsSorted("Till", false));

    }
}

