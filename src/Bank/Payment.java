package Bank;

/**
 * Die Klasse Payment erbt Eigenschaften von Transaction und fügt zusätzliche Parameter für eingehende und ausgehende Zinsen hinzu.
 */
public class Payment extends Transaction {
    private double incomingInterest;
    private double outgoingInterest;

    /**
     * Erstellt ein Payment-Objekt mit den angegebenen Parametern, die von der Oberklasse Transaction übernommen werden.
     *
     * @param date Das Datum der Transaktion.
     * @param amount Der Betrag der Transaktion.
     * @param description Eine Beschreibung der Transaktion.
     */
    public Payment(String date, double amount, String description) {
        super(date, amount, description);
    }

    /**
     * Erstellt ein Payment-Objekt mit den Parametern der Oberklasse und zusätzlichen Zinsparametern für eingehende und ausgehende Zahlungen.
     *
     * @param date Das Datum der Transaktion.
     * @param amount Der Betrag der Transaktion.
     * @param description Eine Beschreibung der Transaktion.
     * @param incomingInterest Der Zinssatz für eingehende Zahlungen.
     * @param outgoingInterest Der Zinssatz für ausgehende Zahlungen.
     */
    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest) {
        this(date, amount, description);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * Erstellt eine Kopie des Payment-Objekts.
     *
     * @param copy Das zu kopierende Payment-Objekt.
     */
    public Payment(Payment copy) {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getIncomingInterest(), copy.getOutgoingInterest());
    }

    /**
     * Gibt den Zinssatz für eingehende Zahlungen zurück.
     *
     * @return Der Zinssatz für eingehende Zahlungen.
     */
    public double getIncomingInterest() {
        return incomingInterest;
    }

    /**
     * Setzt den Zinssatz für eingehende Zahlungen.
     *
     * @param incomingInterest Der zu setzende Zinssatz für eingehende Zahlungen.
     */
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest >= 0 && incomingInterest <= 1) {
            this.incomingInterest = incomingInterest;
        } else {
            System.out.println("Ungültiger Eingangszinssatz");
        }
    }

    /**
     * Gibt den Zinssatz für ausgehende Zahlungen zurück.
     *
     * @return Der Zinssatz für ausgehende Zahlungen.
     */
    public double getOutgoingInterest() {
        return outgoingInterest;
    }

    /**
     * Setzt den Zinssatz für ausgehende Zahlungen.
     *
     * @param outgoingInterest Der zu setzende Zinssatz für ausgehende Zahlungen.
     */
    public void setOutgoingInterest(double outgoingInterest) {
        if (outgoingInterest >= 0 && outgoingInterest <= 1) {
            this.outgoingInterest = outgoingInterest;
        } else {
            System.out.println("Ungültiger Ausgangszinssatz");
        }
    }

    /**
     * Überschreibt die calculate-Methode, um den Betrag unter Berücksichtigung der Zinsen zu berechnen.
     *
     * @return Der berechnete Betrag nach Berücksichtigung der Zinsen.
     */
    @Override
    public double calculate() {
        double result;
        if (getAmount() > 0) {
            result = getAmount() - ((getAmount() * getIncomingInterest()));
        } else {
            result = getAmount() + ((getAmount() * getOutgoingInterest()));
        }
        return result;
    }

    /**
     * Gibt eine Zeichenfolge dar, die die Transaktionsinformationen einschließlich der Zinsen enthält.
     *
     * @return Die Transaktionsinformationen als Zeichenfolge.
     */
    @Override
    public String toString() {
        return (super.toString() +
                "Incoming Interest: " + getIncomingInterest() + "\n" +
                "Outgoing Interest: " + getOutgoingInterest());
    }

    /**
     * Überprüft, ob dieses Payment-Objekt gleich einem anderen Objekt ist.
     *
     * @param other Das zu vergleichende Objekt.
     * @return true, wenn die Objekte gleich sind, andernfalls false.
     */

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Payment otherPayment)) return false;

        return (super.equals(otherPayment) &&
                getIncomingInterest() == otherPayment.getIncomingInterest() &&
                getOutgoingInterest() == otherPayment.getOutgoingInterest());
    }
}
