package Bank;

/**
 * Die Klasse Transfer erbt Eigenschaften von Transaction und fügt zusätzliche Parameter für den Sender und den Empfänger hinzu.
 */
public class Transfer extends Transaction {
    private String sender;
    private String recipient;

    /**
     * Erstellt ein Transfer-Objekt mit den angegebenen Parametern, die von der Oberklasse Transaction übernommen werden.
     *
     * @param date Das Datum der Transaktion.
     * @param amount Der Betrag der Transaktion.
     * @param description Eine Beschreibung der Transaktion.
     * @param sender Der Sender der Überweisung.
     * @param recipient Der Empfänger der Überweisung.
     */
    public Transfer(String date, double amount, String description, String sender, String recipient) {
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    /**
     * Erstellt eine Kopie des Transfer-Objekts.
     *
     * @param copy Das zu kopierende Transfer-Objekt.
     */
    public Transfer(Transfer copy) {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getSender(), copy.getRecipient());
    }

    /**
     * Setzt den Betrag der Überweisung. Falls der Betrag negativ ist, wird eine Meldung ausgegeben.
     *
     * @param a Der zu setzende Betrag der Überweisung.
     */
    @Override
    public void setAmount(Double a) {
        if (a <= 0) {
            System.out.println("Negative Überweisung?");
        } else {
            super.setAmount(a);
        }
    }

    /**
     * Gibt den Sender der Überweisung zurück.
     *
     * @return Der Sender der Überweisung.
     */
    String getSender() {
        return sender;
    }

    /**
     * Setzt den Sender der Überweisung.
     *
     * @param s Der zu setzende Sender der Überweisung.
     */
    void setSender(String s) {
        sender = s;
    }

    /**
     * Gibt den Empfänger der Überweisung zurück.
     *
     * @return Der Empfänger der Überweisung.
     */
    String getRecipient() {
        return recipient;
    }

    /**
     * Setzt den Empfänger der Überweisung.
     *
     * @param r Der zu setzende Empfänger der Überweisung.
     */
    void setRecipient(String r) {
        recipient = r;
    }

    /**
     * Berechnet den Betrag der Überweisung, der unverändert zurückgegeben wird.
     *
     * @return Der Betrag der Überweisung.
     */
    @Override
    public double calculate() {
        return getAmount();
    }

    /**
     * Gibt eine Zeichenfolge dar, die die Transaktionsinformationen einschließlich Sender und Empfänger enthält.
     *
     * @return Die Transaktionsinformationen als Zeichenfolge.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Sender: " + getSender() + "\n" +
                "Recipient: " + getRecipient();
    }

    /**
     * Überprüft, ob dieses Transfer-Objekt gleich einem anderen Objekt ist.
     *
     * @param other Das zu vergleichende Objekt.
     * @return true, wenn die Objekte gleich sind, andernfalls false.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Transfer otherTransfer)) return false;

        return (super.equals(otherTransfer) &&
                getSender().equals(otherTransfer.getSender()) &&
                getRecipient().equals(otherTransfer.getRecipient()));
    }
}
