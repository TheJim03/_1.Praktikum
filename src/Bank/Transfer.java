package Bank;

/**
 * Die Klasse Transfer soll die Klasse Payment erweitern. Sie soll die Attribute sender und recipient
 * enthalten. Die Klasse soll einen Konstruktor mit den Parametern date, amount, description, sender und
 * recipient besitzen. Die Klasse soll einen Copy-Konstruktor besitzen. Die Klasse soll die Methoden
 * getSender() und getRecipient() besitzen. Die Klasse soll die Methoden setSender() und setRecipient()
 * besitzen. Die Klasse soll die Methode toString() überschreiben. Die Klasse soll die Methode equals()
 * überschreiben.
 * Die Klasse soll die Methode calculate() überschreiben. Die Methode soll den Betrag des Transfers
 * zurückgeben.
 * Die Klasse soll die Methode setAmount() überschreiben. Die Methode soll den Betrag des Transfers
 * setzen. Der Betrag darf nicht negativ sein.
 */
public class Transfer extends Transaction
{
    /**
     * Die Klasse soll die Attribute sender und recipient enthalten.
     */
    private String sender;
    private String recipient;

    /**
     * Die Klasse soll einen Konstruktor mit den Parametern date, amount, description, sender und
     * recipient besitzen.
     */
    public Transfer(String date, double amount, String description, String sender, String recipient)
    {
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    /**
     * Die Klasse soll einen Copy-Konstruktor besitzen.
     */
    public Transfer(Transfer copy)
    {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getSender(), copy.getRecipient());
    }

    /**
     * Die Klasse soll die Methoden getSender() und getRecipient() besitzen.
     * setAmound() überschreiben. Die Methode soll den Betrag des Transfers setzen. Der Betrag darf nicht negativ sein.
     */
   public void setAmount(double a)
    {
        if(a <= 0) System.out.println("Negative Transfer?");
        else super.setAmount(a);
    }

    String getSender() {return sender;}
    void setSender(String s) {sender = s;}

    String getRecipient() {return recipient;}
    void setRecipient(String r) {recipient = r;}


    @Override
    public double calculate() {
        return getAmount();
    }

    /*public void printObject() {
        System.out.println("Date: " + getDate());
        System.out.println("Amount: " + getAmount());
        System.out.println("Description: " + getDescription());
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
    }*/

    /**
     * Die Klasse soll die Methode toString() überschreiben.
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "Sender: " + getSender() + "\n" +
                "Recipient: " + getRecipient();
    }

    /**
     * Die Klasse soll die Methode equals() überschreiben.
     */
    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Transfer otherTransfer)) return false;

        return (super.equals(otherTransfer) &&
                getSender().equals(otherTransfer.getSender()) &&
                getRecipient().equals(otherTransfer.getRecipient()));
    }
}
