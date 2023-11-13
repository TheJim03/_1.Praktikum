package bank;

/**
 * Die abstrakte Klasse Transaction stellt grundlegende Parameter wie Datum, Betrag und Beschreibung bereit.
 */
public abstract class Transaction implements CalculateBill {
    protected String date;
    protected double amount;
    protected String description;

    /**
     * Erstellt ein Transaction-Objekt mit den angegebenen Parametern.
     *
     * @param date Das Datum der Transaktion.
     * @param amount Der Betrag der Transaktion.
     * @param description Eine Beschreibung der Transaktion.
     */
    public Transaction(String date, double amount, String description) {
        setDate(date);
        setAmount(amount);
        setDescription(description);
    }

    /**
     * Gibt das Datum der Transaktion zurück.
     *
     * @return Das Datum der Transaktion.
     */
    public String getDate() {
        return date;
    }

    /**
     * Setzt das Datum der Transaktion.
     *
     * @param d Das zu setzende Datum.
     */
    public void setDate(String d) {
        date = d;
    }

    /**
     * Gibt den Betrag der Transaktion zurück.
     *
     * @return Der Betrag der Transaktion.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setzt den Betrag der Transaktion.
     *
     * @param a Der zu setzende Betrag.
     */
    public void setAmount(double a) {
        amount = a;
    }

    /**
     * Gibt die Beschreibung der Transaktion zurück.
     *
     * @return Die Beschreibung der Transaktion.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt die Beschreibung der Transaktion.
     *
     * @param d Die zu setzende Beschreibung.
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Gibt eine Zeichenfolge dar, die die Transaktionsinformationen enthält.
     *
     * @return Die Transaktionsinformationen als Zeichenfolge.
     */
    @Override
    public String toString() {
        return ("Date: " + getDate() + "\n" +
                "Amount: " + calculate() + "\n" +
                "Description: " + getDescription() + "\n");
    }

    /**
     * Überprüft, ob dieses Objekt gleich einem anderen Objekt ist.
     *
     * @param other Das zu vergleichende Objekt.
     * @return true, wenn die Objekte gleich sind, andernfalls false.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Transaction otherTransaction)) return false;

        return (getDate().equals(otherTransaction.getDate()) &&
                getAmount() == otherTransaction.getAmount() &&
                getDescription().equals(otherTransaction.getDescription()));
    }
}
