package Bank;


/**
 * Die Klasse Payment soll die Klasse Transaction erweitern. Sie soll die Attribute incomingInterest und
 * outgoingInterest enthalten. Die Klasse soll einen Konstruktor mit den Parametern date, amount und
 * description besitzen. Die Klasse soll einen Copy-Konstruktor besitzen. Die Klasse soll die Methoden
 * getIncomingInterest() und getOutgoingInterest() besitzen. Die Klasse soll die Methoden
 * setIncomingInterest() und setOutgoingInterest() besitzen. Die Klasse soll die Methode toString()
 * überschreiben. Die Klasse soll die Methode equals() überschreiben.
 * Die Klasse soll die Methode calculate() überschreiben. Die Methode soll den Betrag der Zahlung
 * zurückgeben. Der Betrag darf nicht negativ sein.
 * Die Klasse soll die Methode setAmount() überschreiben. Die Methode soll den Betrag der Zahlung
 * setzen. Der Betrag darf nicht negativ sein.
 * Die Klasse soll die Methode printObject() besitzen. Die Methode soll die Attribute der Klasse auf der
 * Konsole ausgeben.
 */
public class Payment extends Transaction
{
    private double incomingInterest;
    private double outgoingInterest;


    public Payment(String date, double amount, String description)
    {
        super(date, amount, description);
    }

    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest) {
        this(date, amount, description);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    //copy
    public Payment(Payment copy) {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getIncomingInterest(), copy.getOutgoingInterest());
    }

    //getter/setter

    public double getIncomingInterest() {return incomingInterest;}
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest >= 0 && incomingInterest <= 1) {
            this.incomingInterest = incomingInterest;
        } else {
            System.out.println("Ungültiger Eingangszinssatz");
        }
    }

    public double getOutgoingInterest() {return outgoingInterest;}
    public void setOutgoingInterest(double outgoingInterest)
    {
        if (outgoingInterest >= 0 && outgoingInterest <= 1)
        {
            this.outgoingInterest = outgoingInterest;
        }
        else
        {
            System.out.println("Ungültiger Ausgangszinssatz");
        }
    }

    @Override
    public double calculate()
    {
        double result;
        if (getAmount() > 0)
        {
            result = getAmount() - ((getAmount() * getIncomingInterest()));
        } else {
            result = getAmount() + ((getAmount() * getOutgoingInterest()));
        }
        return result;
    }

    /*public void printObject()
    {
        System.out.println("Date: " + getDate());
        System.out.println("Amount: " + getAmount());
        System.out.println("Description: " + getDescription());
        System.out.println("Incoming Interest: " + incomingInterest);
        System.out.println("Outgoing Interest: " + outgoingInterest);
    }*/

    @Override
    public String toString()
    {
        return (super.toString() +
                "Incoming Interest: " + getIncomingInterest() + "\n" +
                "Outgoing Interest: " + getOutgoingInterest());
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Payment otherPayment)) return false;

        return (super.equals(otherPayment) &&
                getIncomingInterest() == otherPayment.getIncomingInterest() &&
                getOutgoingInterest() == otherPayment.getOutgoingInterest());
    }
}
