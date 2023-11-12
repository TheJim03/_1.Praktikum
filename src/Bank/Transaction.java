package Bank;

/**
 * Die Klasse Transaction soll als abstrakte Basisklasse für die Klassen Payment und Transfer dienen.
 * Sie soll die Attribute date, amount und description enthalten. Die Klasse soll einen Konstruktor
 * mit den Parametern date, amount und description besitzen. Die Klasse soll eine Methode toString()
 * besitzen, die die Attribute der Klasse als String zurückgibt. Die Klasse soll eine Methode
 * equals() besitzen, die zwei Objekte der Klasse vergleicht und true zurückgibt, wenn die Objekte
 * gleich sind, sonst false.
 */
public abstract class Transaction implements CalculateBill
{
    /**
     * Die Klasse soll die Attribute date, amount und description enthalten.
     */
    protected String date;
    protected double amount;
    protected String description;

    /**
     * Die Klasse soll einen Konstruktor mit den Parametern date, amount und description besitzen.
     */
    public Transaction(String date, double amount, String description)
    {
        setDate(date);
        setAmount(amount);
        setDescription(description);
    }


    public String getDate() {return date;}
    public void setDate(String d) {date = d;}

    public double getAmount() {return amount;}
    public void setAmount(Double a) {amount = a;}

    public String getDescription() {return description;}
    public void setDescription(String d) {description = d;}

    /**
     * Die Klasse soll eine Methode toString() besitzen, die die Attribute der Klasse als String zurückgibt.
     */
    @Override
    public String toString()
    {
        return ("Date: " + getDate() + "\n" +
                "Amount: " + calculate() + "\n" +
                "Description: " + getDescription() + "\n");
    }

    /**
     * Die Klasse soll eine Methode equals() besitzen, die zwei Objekte der Klasse vergleicht und true zurückgibt,
     * wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object other)
    {
        if(!(other instanceof Transaction otherTransaction)) return false;

        return (getDate().equals(otherTransaction.getDate()) &&
            getAmount() == otherTransaction.getAmount() &&
            getDescription().equals(otherTransaction.getDescription()));
    }
}